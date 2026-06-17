import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import ast.builder.FlaskASTBuilder;
import ast.builder.TemplateASTBuilder;
import ast.flask.FlaskASTNode;
import ast.template.TemplateASTNode;
import ast.semantic.SemanticAnalyzer;
import ast.semantic.SemanticError;
import ast.codegen.CodeGenerator;
import gen.grammers.MiniFlaskLexer;
import gen.grammers.MiniFlaskParser;
import gen.grammers.MiniTemplateLexer;
import gen.grammers.MiniTemplateParser;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class Main {

    // --------------------------------------------------
    // Entry point
    // --------------------------------------------------
    public static void main(String[] args) throws Exception {

        // Collect ASTs for semantic analysis
        List<FlaskASTNode> flaskAsts = new ArrayList<>();
        Map<String, TemplateASTNode> templateAsts = new LinkedHashMap<>();
        Map<String, String> templateFileMap = new HashMap<>();
        // Parse and print all ASTs (maintaining original flow)
        try {
            flaskAsts.add(printFlaskAST("================================================================ Flask AST ================================================================",
                    "tests/FlaskTest3(scopes)"));
        } catch (Exception e) {
            System.out.println("Error in FlaskTest3(scopes): " + e.getMessage());
        }

        printParseTree();

        // App Flask + templates
        FlaskASTNode appFlaskAst = null;
        try {
            FlaskASTNode ast = printFlaskAST("================================================================ Flask AST ================================================================",
                    "App/app.txt");
            flaskAsts.add(ast);
            appFlaskAst = ast;
        } catch (Exception e) {
            System.out.println("Error in App/app.txt: " + e.getMessage());
        }
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Index Template AST ================================================================",
                    "App/indexTemplate.txt");
            templateAsts.put("index.html", ast);
            templateFileMap.put("index.html", "App/indexTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/indexTemplate.txt: " + e.getMessage());
        }
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Create Template AST ================================================================",
                    "App/createTemplate.txt");
            templateAsts.put("create.html", ast);
            templateFileMap.put("create.html", "App/createTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/createTemplate.txt: " + e.getMessage());
        }
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Show Template AST ================================================================",
                    "App/showTemplate.txt");
            templateAsts.put("show.html", ast);
            templateFileMap.put("show.html", "App/showTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/showTemplate.txt: " + e.getMessage());
        }

        // Flask Tests
        try {
            flaskAsts.add(printFlaskAST("================================================================ Test 1 ================================================================",
                    "tests/FlaskTest1"));
        } catch (Exception e) {
            System.out.println("Error in FlaskTest1: " + e.getMessage());
        }
        try {
            flaskAsts.add(printFlaskAST("================================================================ Test 2 ================================================================",
                    "tests/FlaskTest2"));
        } catch (Exception e) {
            System.out.println("Error in FlaskTest2: " + e.getMessage());
        }

        // Template Tests (no matching Flask render_template — used to demonstrate Missing Flask Variable)
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Test 1 ================================================================",
                    "tests/JinjaTest1");
            templateAsts.put("JinjaTest1", ast);
            templateFileMap.put("JinjaTest1", "tests/JinjaTest1");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest1: " + e.getMessage());
        }
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Test 2 ================================================================",
                    "tests/JinjaTest2");
            templateAsts.put("JinjaTest2", ast);
            templateFileMap.put("JinjaTest2", "tests/JinjaTest2");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest2: " + e.getMessage());
        }
        try {
            TemplateASTNode ast = printTemplateAST("================================================================ Test 3 ================================================================",
                    "tests/JinjaTest3");
            templateAsts.put("JinjaTest3", ast);
            templateFileMap.put("JinjaTest3", "tests/JinjaTest3");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest3: " + e.getMessage());
        }

        // ================================================================
        // SEMANTIC ANALYSIS
        // ================================================================
        System.out.println("\n\n");
        System.out.println("====================================================================================================");
        System.out.println("  SEMANTIC ANALYSIS");
        System.out.println("====================================================================================================");

        List<SemanticError> totalFlaskErrors = new ArrayList<>();
        SemanticAnalyzer combinedAnalyzer = new SemanticAnalyzer();
        Map<String, Set<String>> globalTemplateContextMap = new HashMap<>();

        // Analyze all Flask ASTs and aggregate template context
        for (FlaskASTNode flaskAst : flaskAsts) {
            SemanticAnalyzer analyzer = new SemanticAnalyzer();
            Map<String, Set<String>> ctxMap = analyzer.analyzeFlask(flaskAst);
            totalFlaskErrors.addAll(analyzer.getAllErrors());
            // Merge template context maps
            for (Map.Entry<String, Set<String>> entry : ctxMap.entrySet()) {
                globalTemplateContextMap.merge(entry.getKey(), entry.getValue(), (a, b) -> { a.addAll(b); return a; });
            }
        }

        // Print Flask errors
        SemanticAnalyzer.printErrors(totalFlaskErrors, "FLASK SEMANTIC ERRORS");

        // Analyze all template ASTs
        List<SemanticError> totalTemplateErrors = new ArrayList<>();
        for (Map.Entry<String, TemplateASTNode> entry : templateAsts.entrySet()) {
            String templateName = entry.getKey();
            TemplateASTNode templateAst = entry.getValue();

            SemanticAnalyzer analyzer = new SemanticAnalyzer();
            analyzer.analyzeTemplate(templateAst, templateName, globalTemplateContextMap);
            totalTemplateErrors.addAll(analyzer.getAllErrors());
        }

        // Print Template errors
        SemanticAnalyzer.printErrors(totalTemplateErrors, "TEMPLATE SEMANTIC ERRORS");

        // Print combined summary
        List<SemanticError> allErrors = new ArrayList<>();
        allErrors.addAll(totalFlaskErrors);
        allErrors.addAll(totalTemplateErrors);
        System.out.println("\nTOTAL SEMANTIC ERRORS FOUND: " + allErrors.size());
        if (!allErrors.isEmpty()) {
            System.out.println("Breakdown:");
            Map<String, Long> counts = new LinkedHashMap<>();
            for (SemanticError e : allErrors) {
                counts.merge(e.getErrorType(), 1L, Long::sum);
            }
            for (Map.Entry<String, Long> c : counts.entrySet()) {
                System.out.println("  " + c.getKey() + ": " + c.getValue());
            }
        }

        // ================================================================
        // CODE GENERATION
        // ================================================================
        System.out.println("\n\n");
        System.out.println("====================================================================================================");
        System.out.println("  CODE GENERATION");
        System.out.println("====================================================================================================");

        if (appFlaskAst != null) {
            try {
                Map<String, TemplateASTNode> appTemplates = new LinkedHashMap<>();
                appTemplates.put("index.html", templateAsts.get("index.html"));
                appTemplates.put("show.html", templateAsts.get("show.html"));
                appTemplates.put("create.html", templateAsts.get("create.html"));
                appTemplates.put("delete.html", templateAsts.get("delete.html"));
                CodeGenerator generator = new CodeGenerator(appFlaskAst, appTemplates);
                generator.generate();
                System.out.println("Code generation complete. Output: App/generated/");
            } catch (Exception e) {
                System.out.println("Code generation failed: " + e.getMessage());
            }
        } else {
            System.out.println("No app AST available, skipping code generation.");
        }

    }

    private static FlaskASTNode printFlaskAST(String title, String filePath) throws Exception {
        System.out.println("\n" + title);

        MiniFlaskParser parser = createFlaskParser(filePath);
        ParseTree tree = parser.file();

        FlaskASTNode ast = new FlaskASTBuilder().visit(tree);
        System.out.println(ast);
        return ast;
    }

    private static TemplateASTNode printTemplateAST(String title, String filePath) throws Exception {
        System.out.println("\n" + title);

        MiniTemplateParser parser = createTemplateParser(filePath);
        ParseTree tree = parser.template();

        TemplateASTNode ast = new TemplateASTBuilder().visit(tree);
        System.out.println(ast);
        return ast;
    }

    // --------------------------------------------------
    // Parser creation helpers
    // --------------------------------------------------
    private static MiniFlaskParser createFlaskParser(String filePath) throws Exception {
        CharStream input = CharStreams.fromFileName(filePath);
        MiniFlaskLexer lexer = new MiniFlaskLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new MiniFlaskParser(tokens);
    }

    private static MiniTemplateParser createTemplateParser(String filePath) throws Exception {
        CharStream input = CharStreams.fromFileName(filePath);
        MiniTemplateLexer lexer = new MiniTemplateLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new MiniTemplateParser(tokens);
    }

    // --------------------------------------------------
    // Parser tree printing (UNCHANGED LOGIC)
    // --------------------------------------------------
    private static void printParseTree() throws Exception {

        parseAndPrint(
                "================================================================ Flask Parse Tree ================================================================",
                "tests/FlaskTest3(scopes)",
                MiniFlaskLexer::new,
                MiniFlaskParser::new,
                parser -> ((MiniFlaskParser) parser).file()
        );

        parseAndPrint(
                "================================================================ Index Template Parse Tree ================================================================",
                "App/indexTemplate.txt",
                MiniTemplateLexer::new,
                MiniTemplateParser::new,
                parser -> ((MiniTemplateParser) parser).template()
        );

        parseAndPrint(
                "================================================================ Create Template Parse Tree ================================================================",
                "App/createTemplate.txt",
                MiniTemplateLexer::new,
                MiniTemplateParser::new,
                parser -> ((MiniTemplateParser) parser).template()
        );

        parseAndPrint(
                "================================================================ Show Template Parse Tree ================================================================",
                "App/showTemplate.txt",
                MiniTemplateLexer::new,
                MiniTemplateParser::new,
                parser -> ((MiniTemplateParser) parser).template()
        );
    }

    // --------------------------------------------------
    // Generic parse + print pipeline (parser tree)
    // --------------------------------------------------
    private static <L extends Lexer, P extends Parser> void parseAndPrint(
            String title,
            String filePath,
            LexerFactory<L> lexerFactory,
            ParserFactory<P> parserFactory,
            ParseEntry<P> entryRule
    ) throws Exception {

        System.out.println("\n" + title);

        CharStream input = CharStreams.fromFileName(filePath);
        L lexer = lexerFactory.create(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        P parser = parserFactory.create(tokens);

        ParseTree tree = entryRule.parse(parser);
        printTree(tree, parser, 0);
    }

    // --------------------------------------------------
    // Pretty parse tree printer (UNCHANGED)
    // --------------------------------------------------
    private static void printTree(ParseTree tree, Parser parser, int depth) {
        String indent = "  ".repeat(depth);

        if (tree instanceof RuleContext ctx) {
            String ruleName = parser.getRuleNames()[ctx.getRuleIndex()];
            System.out.println(indent + ruleName);

            for (int i = 0; i < tree.getChildCount(); i++) {
                printTree(tree.getChild(i), parser, depth + 1);
            }
        }
        else if (tree instanceof TerminalNode tn) {
            if (!tn.getText().equals("<EOF>")) {
                String tokenName = parser.getVocabulary()
                        .getSymbolicName(tn.getSymbol().getType());

                if (tokenName != null) {
                    System.out.println(
                            indent + tokenName + " \"" + tn.getText() + "\""
                    );
                }
            }
        }
    }


    // --------------------------------------------------
    // Functional helpers (parser tree only)
    // --------------------------------------------------
    @FunctionalInterface
    interface LexerFactory<L extends Lexer> {
        L create(CharStream input);
    }

    @FunctionalInterface
    interface ParserFactory<P extends Parser> {
        P create(TokenStream tokens);
    }

    @FunctionalInterface
    interface ParseEntry<P extends Parser> {
        ParseTree parse(P parser);
    }
}