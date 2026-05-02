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
import gen.grammers.MiniFlaskLexer;
import gen.grammers.MiniFlaskParser;
import gen.grammers.MiniTemplateLexer;
import gen.grammers.MiniTemplateParser;

public class Main {

    // --------------------------------------------------
    // Entry point
    // --------------------------------------------------
    public static void main(String[] args) throws Exception {

        try {
            printFlaskAST("================================================================ Flask AST ================================================================",
                    "tests/FlaskTest3(scopes)");
        } catch (Exception e) {
            System.out.println("Error in FlaskTest3(scopes): " + e.getMessage());
        }
        // Parser Trees
        printParseTree();

        try {
            printFlaskAST("================================================================ Flask AST ================================================================",
                    "App/app.txt");
        } catch (Exception e) {
            System.out.println("Error in App/app.txt: " + e.getMessage());
        }
        try {
            printTemplateAST("================================================================ Index Template AST ================================================================",
                    "App/indexTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/indexTemplate.txt: " + e.getMessage());
        }
        try {
            printTemplateAST("================================================================ Create Template AST ================================================================",
                    "App/createTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/createTemplate.txt: " + e.getMessage());
        }
        try {
            printTemplateAST("================================================================ Show Template AST ================================================================",
                    "App/showTemplate.txt");
        } catch (Exception e) {
            System.out.println("Error in App/showTemplate.txt: " + e.getMessage());
        }

        // Flask Tests
        try {
            printFlaskAST("================================================================ Test 1 ================================================================",
                    "tests/FlaskTest1");
        } catch (Exception e) {
            System.out.println("Error in FlaskTest1: " + e.getMessage());
        }
        try {
            printFlaskAST("================================================================ Test 2 ================================================================",
                    "tests/FlaskTest2");
        } catch (Exception e) {
            System.out.println("Error in FlaskTest2: " + e.getMessage());
        }

        // Template Tests
        try {
            printTemplateAST("================================================================ Test 1 ================================================================",
                    "tests/JinjaTest1");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest1: " + e.getMessage());
        }
        try {
            printTemplateAST("================================================================ Test 2 ================================================================",
                    "tests/JinjaTest2");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest2: " + e.getMessage());
        }
        try {
            printTemplateAST("================================================================ Test 3 ================================================================",
                    "tests/JinjaTest3");
        } catch (Exception e) {
            System.out.println("Error in JinjaTest3: " + e.getMessage());
        }

    }

    private static void printFlaskAST(String title, String filePath) throws Exception {
        System.out.println("\n" + title);

        MiniFlaskParser parser = createFlaskParser(filePath);
        ParseTree tree = parser.file();

        FlaskASTNode ast = new FlaskASTBuilder().visit(tree);
        System.out.println(ast);
    }

    private static void printTemplateAST(String title, String filePath) throws Exception {
        System.out.println("\n" + title);

        MiniTemplateParser parser = createTemplateParser(filePath);
        ParseTree tree = parser.template();

        TemplateASTNode ast = new TemplateASTBuilder().visit(tree);
        System.out.println(ast);
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
                            indent + tokenName + " → \"" + tn.getText() + "\""
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
