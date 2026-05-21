package ast.semantic;

import ast.flask.FlaskASTNode;
import ast.flask.expr.*;
import ast.flask.misc.*;
import ast.flask.stmt.*;

import java.util.*;

public class FlaskSemanticAnalyzer {

    private final List<SemanticError> errors;
    private final Deque<Map<String, String>> scopeStack;    // var name → type
    private final Deque<String> scopeNameStack;              // scope name for debug
    private final Map<String, Set<String>> templateContextMap; // template file → context vars
    private final Deque<ExitedScope> exitedScopes;           // for Scope Error detection

    private static class ExitedScope {
        final String name;
        final Map<String, String> variables;
        ExitedScope(String name, Map<String, String> variables) {
            this.name = name;
            this.variables = new HashMap<>(variables);
        }
    }

    public FlaskSemanticAnalyzer() {
        this.errors = new ArrayList<>();
        this.scopeStack = new ArrayDeque<>();
        this.scopeNameStack = new ArrayDeque<>();
        this.templateContextMap = new HashMap<>();
        this.exitedScopes = new ArrayDeque<>();
        enterScope("global");
        define("__name__", "string");
        define("render_template", "function");
        define("request", "object");
        define("redirect", "function");
        define("url_for", "function");
        define("Flask", "class");
        define("next", "function");
        define("len", "function");
        define("max", "function");
    }

    /**
     * Analyze the Flask AST, return collected errors.
     * After analysis, getTemplateContextMap() provides the
     * template-name → context-variables mapping.
     */
    public List<SemanticError> analyze(FlaskASTNode root) {
        visitNode(root);
        exitScope();
        return errors;
    }

    public Map<String, Set<String>> getTemplateContextMap() {
        return templateContextMap;
    }

    // ---------------------------------------------------------------
    // Scope management
    // ---------------------------------------------------------------

    private void enterScope(String name) {
        scopeStack.push(new HashMap<>());
        scopeNameStack.push(name);
    }

    private void exitScope() {
        Map<String, String> data = scopeStack.pop();
        String name = scopeNameStack.pop();
        // Persist function and generator scopes so we can detect out-of-scope variable access
        if (name.startsWith("function:") || name.equals("generator")) {
            exitedScopes.push(new ExitedScope(name, data));
        }
    }

    private void define(String varName, String type) {
        scopeStack.peek().put(varName, type != null ? type : "unknown");
    }

    private String resolve(String varName) {
        for (Map<String, String> scope : scopeStack) {
            String type = scope.get(varName);
            if (type != null) return type;
        }
        return null;
    }

    /** Check if a variable exists in ANY scope (including unreachable ones). */
    private boolean existsInAnyScope(String varName) {
        for (Map<String, String> scope : scopeStack) {
            if (scope.containsKey(varName)) return true;
        }
        return false;
    }

    // ---------------------------------------------------------------
    // Main dispatch
    // ---------------------------------------------------------------

    private void visitNode(FlaskASTNode node) {
        if (node == null) return;

        if (node instanceof FileNodeFlask)          visitFileNodeFlask((FileNodeFlask) node);
        else if (node instanceof AssignStmt)        visitAssignStmt((AssignStmt) node);
        else if (node instanceof FuncDefStmt)       visitFuncDefStmt((FuncDefStmt) node);
        else if (node instanceof RouteDefStmt)      visitRouteDefStmt((RouteDefStmt) node);
        else if (node instanceof IfStmt)            visitIfStmt((IfStmt) node);
        else if (node instanceof ReturnStmt)        visitReturnStmt((ReturnStmt) node);
        else if (node instanceof ImportStmt)        visitImportStmt((ImportStmt) node);
        else if (node instanceof FromImportStmt)    visitFromImportStmt((FromImportStmt) node);
        else if (node instanceof ExprStmt)          visitExprStmt((ExprStmt) node);
        else if (node instanceof Param)             { /* visited via FuncDefStmt */ }
        else if (node instanceof ArgKw)             visitArgKw((ArgKw) node);
        else if (node instanceof Args)              { for (ArgKw a : ((Args) node).argKws) visitArgKw(a); }
        else if (node instanceof DictPair)          visitExpr(((DictPair) node).value);
        else if (node instanceof DictPairs)         { for (DictPair p : ((DictPairs) node).pairs) visitExpr(p.value); }
        else {
            for (FlaskASTNode child : node.getChildren()) visitNode(child);
        }
    }

    private String visitExpr(Expr expr) {
        if (expr == null) return "none";

        if (expr instanceof LiteralExpr)        return visitLiteralExpr((LiteralExpr) expr);
        if (expr instanceof NameExpr)           return visitNameExpr((NameExpr) expr);
        if (expr instanceof BinaryExpr)         return visitBinaryExpr((BinaryExpr) expr);
        if (expr instanceof PrimaryExpr)        return visitPrimaryExpr((PrimaryExpr) expr);
        if (expr instanceof CallExpr)           return visitCallExpr((CallExpr) expr);
        if (expr instanceof BoolExpr)           return "boolean";
        if (expr instanceof NoneExpr)           return "none";
        if (expr instanceof ListExpr)           return visitListExpr((ListExpr) expr);
        if (expr instanceof DictExpr)           return visitDictExpr((DictExpr) expr);
        if (expr instanceof GenExpr)            return visitGenExpr((GenExpr) expr);
        if (expr instanceof AttrAccessExpr)     return "unknown";
        if (expr instanceof IndexExpr)          { visitExpr(((IndexExpr) expr).index); return "unknown"; }
        if (expr instanceof AppExpr)            return "object";
        if (expr instanceof TypeExpr)           return "unknown";
        return "unknown";
    }

    // ---------------------------------------------------------------
    // Statement visitors
    // ---------------------------------------------------------------

    private void visitFileNodeFlask(FileNodeFlask node) {
        for (Stmt stmt : node.statements) {
            visitNode(stmt);
        }
    }

    private void visitAssignStmt(AssignStmt node) {
        String valueType = visitExpr(node.value);
        String target = node.target;

        String existingType = resolve(target);
        if (existingType != null && !existingType.equals(valueType)
                && !valueType.equals("unknown") && !existingType.equals("unknown")) {
            errors.add(new SemanticError(
                    "Type Mismatch", node.getNodeName(), node.line,
                    "Variable '" + target + "' was previously typed as '" + existingType
                            + "' but is now assigned a value of type '" + valueType + "'"
            ));
        }

        // If variable doesn't exist in our scope stack, add it
        if (!existsInCurrentScope(target)) {
            define(target, valueType);
        }
    }

    private boolean existsInCurrentScope(String varName) {
        return !scopeStack.isEmpty() && scopeStack.peek().containsKey(varName);
    }

    private void visitFuncDefStmt(FuncDefStmt node) {
        define(node.name, "function");

        enterScope("function:" + node.name);
        for (Param p : node.params) {
            define(p.name, "unknown");
        }
        for (Stmt stmt : node.body) {
            visitNode(stmt);
        }
        exitScope();
    }

    private void visitRouteDefStmt(RouteDefStmt node) {
        // Extract route path if present
        for (RouteArg arg : node.routeArgs) {
            if (arg instanceof RouteArgString) {
                // Path string, not needed for semantic analysis
            } else if (arg instanceof RouteArgKw) {
                // methods=["GET", "POST"] etc.
            }
        }

        // The function definition is already visited as a child
        // Just visit it (it will be dispatched to visitFuncDefStmt)
        visitNode(node.function);
    }

    private void visitIfStmt(IfStmt node) {
        visitExpr(node.condition);

        enterScope("if");
        for (Stmt stmt : node.body) {
            visitNode(stmt);
        }
        exitScope();
    }

    private void visitReturnStmt(ReturnStmt node) {
        if (node.value != null) {
            visitExpr(node.value);
        }
    }

    private void visitImportStmt(ImportStmt node) {
        for (String name : node.names) {
            define(name, "object");
        }
    }

    private void visitFromImportStmt(FromImportStmt node) {
        for (String name : node.names) {
            define(name, "object");
        }
    }

    private void visitExprStmt(ExprStmt node) {
        visitExpr(node.expr);
    }

    private void visitArgKw(ArgKw node) {
        if (node.value != null) {
            visitExpr(node.value);
        }
    }

    // ---------------------------------------------------------------
    // Expression visitors
    // ---------------------------------------------------------------

    private String visitLiteralExpr(LiteralExpr node) {
        Object val = node.value;
        if (val == null) return "none";
        String s = val.toString();
        if (s.startsWith("\"") || s.startsWith("'") || s.startsWith("«")) {
            return "string";
        }
        if (s.matches("-?\\d+(\\.\\d+)?")) {
            return "number";
        }
        return "string";
    }

    private String visitNameExpr(NameExpr node) {
        String name = node.name;
        String type = resolve(name);
        if (type == null) {
            // Check if variable exists in an exited scope (function or generator)
            String scopeName = findInExitedScopes(name);
            if (scopeName != null) {
                error("Scope Error", node,
                    "Variable '" + name + "' is defined in scope '" + scopeName
                    + "' but accessed outside its scope");
            } else {
                error("Undefined Variable", node,
                    "Variable '" + name + "' is used before being declared");
            }
            return "unknown";
        }
        return type;
    }

    /** Search exited scopes for a variable and return the short scope name, or null. */
    private String findInExitedScopes(String varName) {
        for (ExitedScope es : exitedScopes) {
            if (es.variables.containsKey(varName)) {
                String raw = es.name;
                if (raw.startsWith("function:")) {
                    return raw.substring("function:".length());
                }
                return raw; // "generator"
            }
        }
        return null;
    }

    private String visitBinaryExpr(BinaryExpr node) {
        String leftType = visitExpr(node.left);
        String rightType = visitExpr(node.right);
        String op = node.operator;

        // Type checking for arithmetic/comparison
        if ("+".equals(op)) {
            if (bothKnownAndDifferent(leftType, rightType)) {
                errors.add(new SemanticError(
                        "Type Error", node.getNodeName(), node.line,
                        "Cannot apply operator '+' to types '" + leftType + "' and '" + rightType + "'"
                ));
            }
            // Infer result type
            if ("string".equals(leftType) && "string".equals(rightType)) return "string";
            if ("number".equals(leftType) && "number".equals(rightType)) return "number";
            return "unknown";
        }

        if ("==".equals(op)) {
            if (bothKnownAndDifferent(leftType, rightType)) {
                errors.add(new SemanticError(
                    "Type Mismatch", node.getNodeName(), node.line,
                        "Cannot compare types '" + leftType + "' and '" + rightType + "' with '=='"
                ));
            }
            return "boolean";
        }

        return "unknown";
    }

    private String visitPrimaryExpr(PrimaryExpr node) {
        String baseType = visitExpr(node.base);

        // Detect render_template calls
        if (node.base instanceof NameExpr) {
            String name = ((NameExpr) node.base).name;
            if ("render_template".equals(name)) {
                // Extract template name and context variables
                for (Expr suffix : node.suffixes) {
                    if (suffix instanceof CallExpr) {
                        extractTemplateContext((CallExpr) suffix);
                    } else {
                        visitExpr(suffix);
                    }
                }
                return "string"; // render_template returns a string
            }
        }

        // For any other primary expression, visit all suffixes
        for (Expr suffix : node.suffixes) {
            visitExpr(suffix);
        }

        return baseType;
    }

    private void extractTemplateContext(CallExpr call) {
        String templateName = null;
        Set<String> contextVars = new HashSet<>();

        for (ArgKw arg : call.routeArgKws) {
            if (arg.name == null) {
                // Positional argument — first one is the template name
                templateName = extractTemplateName(arg.value);
                visitExpr(arg.value);
            } else {
                // Keyword argument — this is a context variable
                contextVars.add(arg.name);
                if (arg.value != null) {
                    visitExpr(arg.value);
                }
            }
        }

        if (templateName != null && !templateName.isEmpty()) {
            templateContextMap.put(templateName, contextVars);
        }
    }

    /** Extract the template name from an expression, unwrapping PrimaryExpr. */
    private String extractTemplateName(Expr expr) {
        if (expr == null) return null;
        // Unwrap PrimaryExpr
        while (expr instanceof PrimaryExpr) {
            expr = ((PrimaryExpr) expr).base;
        }
        if (expr instanceof LiteralExpr) {
            Object val = ((LiteralExpr) expr).value;
            if (val != null) {
                String s = val.toString();
                if ((s.startsWith("\"") && s.endsWith("\"")) ||
                    (s.startsWith("'") && s.endsWith("'"))) {
                    return s.substring(1, s.length() - 1);
                }
                return s;
            }
        }
        return null;
    }

    private String visitCallExpr(CallExpr node) {
        for (ArgKw arg : node.routeArgKws) {
            visitArgKw(arg);
        }
        return "unknown";
    }

    private String visitListExpr(ListExpr node) {
        String elementType = null;
        for (Expr elem : node.elements) {
            String t = visitExpr(elem);
            if (elementType == null) elementType = t;
        }
        return "list";
    }

    private String visitDictExpr(DictExpr node) {
        for (DictPair pair : node.pairs) {
            visitExpr(pair.value);
        }
        return "dict";
    }

    private String visitGenExpr(GenExpr node) {
        visitExpr(node.iterable);
        enterScope("generator");
        define(node.var, "unknown");
        visitExpr(node.element);
        if (node.condition != null) visitExpr(node.condition);
        exitScope();
        return "generator";
    }

    // ---------------------------------------------------------------
    // Helpers
    // ---------------------------------------------------------------

    private void error(String errorType, FlaskASTNode node, String message) {
        errors.add(new SemanticError(errorType, node.getNodeName(), node.line, message));
    }

    private boolean bothKnownAndDifferent(String a, String b) {
        if ("unknown".equals(a) || "unknown".equals(b)) return false;
        if ("none".equals(a) || "none".equals(b)) return false;
        return !a.equals(b);
    }
}
