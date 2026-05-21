package ast.semantic;

import ast.flask.FlaskASTNode;
import ast.template.TemplateASTNode;

import java.util.*;

/**
 * Unified entry point for semantic analysis.
 * Analyzes Flask AST, extracts template context variables,
 * then analyzes each Template AST against those contexts.
 */
public class SemanticAnalyzer {

    private final List<SemanticError> allErrors;

    public SemanticAnalyzer() {
        this.allErrors = new ArrayList<>();
    }

    /**
     * Run semantic analysis on a Flask AST and collect errors.
     * Returns the template context map for later use.
     */
    public Map<String, Set<String>> analyzeFlask(FlaskASTNode flaskRoot) {
        FlaskSemanticAnalyzer flaskAnalyzer = new FlaskSemanticAnalyzer();
        List<SemanticError> errors = flaskAnalyzer.analyze(flaskRoot);
        allErrors.addAll(errors);
        return flaskAnalyzer.getTemplateContextMap();
    }

    /**
     * Run semantic analysis on a Template AST,
     * using the Flask-derived context variable map.
     */
    public void analyzeTemplate(TemplateASTNode templateRoot,
                                 String templateFileName,
                                 Map<String, Set<String>> templateContextMap) {
        Set<String> contextVars = templateContextMap != null
                ? templateContextMap.getOrDefault(templateFileName, Collections.emptySet())
                : Collections.emptySet();

        TemplateSemanticAnalyzer templateAnalyzer =
                new TemplateSemanticAnalyzer(templateFileName, contextVars);
        List<SemanticError> errors = templateAnalyzer.analyze(templateRoot);
        allErrors.addAll(errors);
    }

    public List<SemanticError> getAllErrors() {
        return allErrors;
    }

    public boolean hasErrors() {
        return !allErrors.isEmpty();
    }

    /**
     * Print all collected errors to stdout in a readable format.
     */
    public static void printErrors(List<SemanticError> errors, String title) {
        if (errors.isEmpty()) {
            System.out.println("\nNo semantic errors found.");
            return;
        }

        System.out.println("\n" + title);
        System.out.println("=" .repeat(title.length()));
        System.out.printf("%-22s %-22s %-6s %s%n", "ERROR TYPE", "NODE", "LINE", "MESSAGE");
        System.out.println("-".repeat(80));

        for (SemanticError err : errors) {
            System.out.println(err);
        }
        System.out.println("=" .repeat(title.length()));
        System.out.println("Total: " + errors.size() + " semantic error(s) found.\n");
    }
}
