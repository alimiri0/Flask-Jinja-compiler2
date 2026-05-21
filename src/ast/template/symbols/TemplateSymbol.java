package ast.template.symbols;

import ast.template.TemplateASTNode;

public class TemplateSymbol {
    public final String name;
    public final TemplateSymbolKind kind;
    public final TemplateASTNode node;
    public final int line;
    public final int column;
    public String type;

    public TemplateSymbol(String name, TemplateSymbolKind kind, TemplateASTNode node, int line, int column) {
        this(name, kind, node, line, column, null);
    }

    public TemplateSymbol(String name, TemplateSymbolKind kind, TemplateASTNode node, int line, int column, String type) {
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
