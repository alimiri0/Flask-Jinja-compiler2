package ast.flask.symbols;

import ast.flask.FlaskASTNode;

public class Symbol {
    public final String name;
    public final SymbolKind kind;
    public final FlaskASTNode node;
    public final int line;
    public final int column;
    public String type;

    public Symbol(String name, SymbolKind kind, FlaskASTNode node, int line, int column) {
        this(name, kind, node, line, column, null);
    }

    public Symbol(String name, SymbolKind kind, FlaskASTNode node, int line, int column, String type) {
        this.name = name;
        this.kind = kind;
        this.node = node;
        this.line = line;
        this.column = column;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
