package ast.semantic;

import ast.template.*;
import ast.template.css.declaration.*;
import ast.template.css.selector.*;
import ast.template.expr.*;
import ast.template.misc.*;

import java.util.*;

public class TemplateSemanticAnalyzer {

    private final List<SemanticError> errors;
    private final Deque<Map<String, String>> scopeStack;
    private final String templateFileName;
    private final Set<String> flaskContextVars;

    public TemplateSemanticAnalyzer(String templateFileName, Set<String> flaskContextVars) {
        this.errors = new ArrayList<>();
        this.scopeStack = new ArrayDeque<>();
        this.templateFileName = templateFileName;
        this.flaskContextVars = flaskContextVars != null ? flaskContextVars : new HashSet<>();
        enterScope("template");
        // Built-in template globals
        define("url_for", "function");
        define("render_template", "function");
        define("range", "function");
        define("True", "boolean");
        define("False", "boolean");
        define("None", "none");
    }

    public List<SemanticError> analyze(TemplateASTNode root) {
        visitNode(root);
        exitScope();
        return errors;
    }

    // ---------------------------------------------------------------
    // Scope management
    // ---------------------------------------------------------------

    private void enterScope(String name) {
        scopeStack.push(new HashMap<>());
    }

    private void exitScope() {
        scopeStack.pop();
    }

    private void define(String varName, String type) {
        if (!scopeStack.isEmpty()) {
            scopeStack.peek().put(varName, type);
        }
    }

    private String resolve(String varName) {
        for (Map<String, String> scope : scopeStack) {
            String type = scope.get(varName);
            if (type != null) return type;
        }
        return null;
    }

    private boolean existsInAnyScope(String varName) {
        for (Map<String, String> scope : scopeStack) {
            if (scope.containsKey(varName)) return true;
        }
        return false;
    }

    // ---------------------------------------------------------------
    // Main dispatch — check MOST specific types FIRST
    // ---------------------------------------------------------------

    private void visitNode(TemplateASTNode node) {
        if (node == null) return;

        // Most specific types first (check before parent TemplateElementNode)
        if (node instanceof TemplateHtmlTagNode) {
            visitHtmlTag((TemplateHtmlTagNode) node);
        } else if (node instanceof TemplateJinjaVarNode) {
            visitJinjaVar((TemplateJinjaVarNode) node);
        } else if (node instanceof TemplateJinjaBlockNode) {
            visitJinjaBlock((TemplateJinjaBlockNode) node);
        } else if (node instanceof TemplateStyleTagNode) {
            visitStyleTag((TemplateStyleTagNode) node);
        } else if (node instanceof TemplateAttrNode) {
            visitAttrNode((TemplateAttrNode) node);
        } else if (node instanceof AttrValueNode) {
            for (QuotedItemNode item : ((AttrValueNode) node).attrValues) {
                visitQuotedItem(item);
            }
        } else if (node instanceof TemplateTextNode) {
            // Plain text — nothing to check
        } else if (node instanceof TemplateElementNode) {
            // Use direct .children field access (TemplateElementNode shadows parent's children)
            for (TemplateASTNode child : ((TemplateElementNode) node).children) {
                visitNode(child);
            }
        } else {
            // Fallback for non-TemplateElementNode types — use direct children field
            for (TemplateASTNode child : node.children) {
                visitNode(child);
            }
        }
    }

    private void visitHtmlTag(TemplateHtmlTagNode node) {
        if (node.tagContent != null) {
            visitNode(node.tagContent);
        }
        for (TemplateASTNode child : node.children) {
            visitNode(child);
        }
    }

    private void visitStyleTag(TemplateStyleTagNode node) {
        // CSS rules — visit to check Jinja vars inside CSS
        visitCssNode(node.rules);
    }

    // ---------------------------------------------------------------
    // Jinja-specific visitors
    // ---------------------------------------------------------------

    private void visitJinjaVar(TemplateJinjaVarNode node) {
        if (node.expr != null) {
            visitTemplateExpr(node.expr);
        }
    }

    private void visitJinjaBlock(TemplateJinjaBlockNode node) {
        String type = node.type;

        if ("for".equals(type)) {
            // {% for varName in iterable %}
            visitTemplateExpr(node.conditionOrIterable);
            enterScope("for");
            if (node.varName != null) {
                define(node.varName, "unknown");
            }
            for (TemplateASTNode child : node.children) {
                visitNode(child);
            }
            exitScope();
        } else if ("if".equals(type) || "elif".equals(type)) {
            // {% if condition %}
            enterScope("if");
            if (node.conditionOrIterable != null) {
                visitTemplateExpr(node.conditionOrIterable);
            }
            for (TemplateASTNode child : node.children) {
                visitNode(child);
            }
            exitScope();
        } else {
            for (TemplateASTNode child : node.children) {
                visitNode(child);
            }
        }
    }

    // ---------------------------------------------------------------
    // Attribute / quoted item visitors
    // ---------------------------------------------------------------

    private void visitAttrNode(TemplateAttrNode node) {
        if (node.attrValueNode != null) {
            for (QuotedItemNode item : node.attrValueNode.attrValues) {
                visitQuotedItem(item);
            }
        }
    }

    private void visitQuotedItem(QuotedItemNode item) {
        if (item instanceof AttrTextNode) {
            // Plain text
        } else if (item instanceof AttrJinjaVarNode) {
            visitJinjaVar(((AttrJinjaVarNode) item).var);
        } else if (item instanceof AttrJinjaBlockNode) {
            visitJinjaBlock(((AttrJinjaBlockNode) item).block);
        }
    }

    // ---------------------------------------------------------------
    // Template expression visitors
    // ---------------------------------------------------------------

    private String visitTemplateExpr(TemplateExpr expr) {
        if (expr == null) return "none";

        if (expr instanceof TemplateLiteralExpr) {
            Object val = ((TemplateLiteralExpr) expr).value;
            if (val == null) return "none";
            String s = val.toString();
            if (s.startsWith("'") || s.startsWith("\"") || s.startsWith("«")) {
                return "string";
            }
            if (s.matches("-?\\d+(\\.\\d+)?")) {
                return "number";
            }
            return "string";
        }

        if (expr instanceof TemplateNameExpr) {
            return visitTemplateNameExpr((TemplateNameExpr) expr);
        }

        if (expr instanceof TemplateBinaryExpr) {
            return visitTemplateBinaryExpr((TemplateBinaryExpr) expr);
        }

        if (expr instanceof TemplatePrimaryExpr) {
            TemplatePrimaryExpr pe = (TemplatePrimaryExpr) expr;
            String baseType = visitTemplateExpr(pe.base);
            for (TemplateExpr suffix : pe.suffixes) {
                visitTemplateExpr(suffix);
            }
            return baseType;
        }

        if (expr instanceof TemplateBoolExpr)     return "boolean";
        if (expr instanceof TemplateNoneExpr)     return "none";
        if (expr instanceof TemplateAppExpr)      return "object";
        if (expr instanceof TemplateAttrAccessExpr) return "unknown";
        if (expr instanceof TemplateIndexExpr)    { visitTemplateExpr(((TemplateIndexExpr) expr).index); return "unknown"; }
        if (expr instanceof TemplateCallExpr) {
            TemplateCallExpr ce = (TemplateCallExpr) expr;
            for (TemplateArgKw arg : ce.routeArgKws) {
                if (arg.value != null) visitTemplateExpr(arg.value);
            }
            return "unknown";
        }
        if (expr instanceof TemplateListExpr) {
            for (TemplateExpr e : ((TemplateListExpr) expr).elements) visitTemplateExpr(e);
            return "list";
        }
        if (expr instanceof TemplateDictExpr) {
            for (TemplateDictPair p : ((TemplateDictExpr) expr).pairs) visitTemplateExpr(p.value);
            return "dict";
        }
        if (expr instanceof TemplateGenExpr) {
            TemplateGenExpr ge = (TemplateGenExpr) expr;
            visitTemplateExpr(ge.iterable);
            enterScope("generator");
            define(ge.var, "unknown");
            visitTemplateExpr(ge.element);
            if (ge.condition != null) visitTemplateExpr(ge.condition);
            exitScope();
            return "generator";
        }

        return "unknown";
    }

    private String visitTemplateNameExpr(TemplateNameExpr node) {
        String name = node.name;
        String type = resolve(name);

        if (type == null) {
            // Check if it's a Flask context variable
            if (!flaskContextVars.contains(name)) {
                // Determine if it's undefined or missing Flask variable
                if (existsInAnyScope(name)) {
                    errors.add(new SemanticError(
                            "Scope Error", node.getNodeName(), node.line,
                            "Template variable '" + name + "' is used outside its valid scope"
                    ));
                } else {
                    errors.add(new SemanticError(
                            "Missing Flask Variable", node.getNodeName(), node.line,
                            "Template references variable '" + name
                                    + "' which was not passed via render_template() to '" + templateFileName + "'"
                    ));
                }
            } else {
                // It IS a Flask context variable — define it in current scope
                define(name, "unknown");
            }
            return "unknown";
        }
        return type;
    }

    private String visitTemplateBinaryExpr(TemplateBinaryExpr node) {
        String leftType = visitTemplateExpr(node.left);
        String rightType = visitTemplateExpr(node.right);
        String op = node.operator;

        if ("+".equals(op) && bothKnownAndDifferent(leftType, rightType)) {
            errors.add(new SemanticError(
                    "Type Error", node.getNodeName(), node.line,
                    "Cannot apply operator '+' to types '" + leftType + "' and '" + rightType + "' in template"
            ));
        }
        if ("==".equals(op) && bothKnownAndDifferent(leftType, rightType)) {
            errors.add(new SemanticError(
                    "Type Mismatch", node.getNodeName(), node.line,
                    "Cannot compare types '" + leftType + "' and '" + rightType + "' in template"
            ));
        }

        if ("string".equals(leftType) && "string".equals(rightType)) return "string";
        if ("number".equals(leftType) && "number".equals(rightType)) return "number";
        return "unknown";
    }

    // ---------------------------------------------------------------
    // CSS — only check Jinja vars embedded inside
    // ---------------------------------------------------------------

    private void visitCssNode(TemplateASTNode node) {
        if (node == null) return;

        if (node instanceof CssRuleNode) {
            CssRuleNode rule = (CssRuleNode) node;
            visitSelectorList(rule.selectors);
            visitDeclarationList(rule.declarations);
        } else if (node instanceof CssRulesNode) {
            for (CssRuleNode rule : ((CssRulesNode) node).rules) {
                visitCssNode(rule);
            }
        } else if (node instanceof CssDeclarationListNode) {
            for (CssDeclarationNode decl : ((CssDeclarationListNode) node).declarations) {
                for (CssValueNode val : decl.values) {
                    visitCssValue(val);
                }
            }
        } else if (node instanceof CssSelectorListNode) {
            for (CssSelectorNode sel : ((CssSelectorListNode) node).selectors) {
                visitCssNode(sel);
            }
        } else if (node instanceof CssSelectorNode) {
            for (SelectorUnitNode unit : ((CssSelectorNode) node).units) {
                for (TemplateASTNode part : unit.parts) {
                    visitCssNode(part);
                }
            }
        }
        // Other CSS node types don't contain Jinja vars
    }

    private void visitSelectorList(CssSelectorListNode list) {
        if (list != null) {
            for (CssSelectorNode sel : list.selectors) {
                for (SelectorUnitNode unit : sel.units) {
                    for (TemplateASTNode part : unit.parts) {
                        if (part instanceof CssJinjaVarNode) {
                            // CSS Jinja var embeds a TemplateJinjaVarNode as expr
                            TemplateASTNode inner = ((CssJinjaVarNode) part).expr;
                            if (inner instanceof TemplateJinjaVarNode) {
                                visitJinjaVar((TemplateJinjaVarNode) inner);
                            }
                        }
                    }
                }
            }
        }
    }

    private void visitDeclarationList(CssDeclarationListNode list) {
        if (list != null) {
            for (CssDeclarationNode decl : list.declarations) {
                for (CssValueNode val : decl.values) {
                    visitCssValue(val);
                }
            }
        }
    }

    private void visitCssValue(CssValueNode val) {
        if (val instanceof CssJinjaVarNode) {
            TemplateASTNode inner = ((CssJinjaVarNode) val).expr;
            if (inner instanceof TemplateJinjaVarNode) {
                visitJinjaVar((TemplateJinjaVarNode) inner);
            }
        } else if (val instanceof CssFunctionNode) {
            for (CssValueNode arg : ((CssFunctionNode) val).args) {
                visitCssValue(arg);
            }
        }
    }

    // ---------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------

    private boolean bothKnownAndDifferent(String a, String b) {
        if ("unknown".equals(a) || "unknown".equals(b)) return false;
        if ("none".equals(a) || "none".equals(b)) return false;
        return !a.equals(b);
    }
}
