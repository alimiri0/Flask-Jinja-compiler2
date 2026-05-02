package ast.flask.expr;

import java.util.List;

public class PrimaryExpr extends Expr {
    public final Expr base;
    public final List<Expr> suffixes;

    public PrimaryExpr(Expr base, List<Expr> suffixes, int line, int column) {
        super(line, column);
        this.nodeName = "PrimaryExpr";
        this.base = base;
        this.suffixes = suffixes;
        addChild(base);
        for (Expr s : suffixes) addChild(s);
    }

    @Override
    public String toString() {
        return "\nPrimaryExpr{ " +
                line + ":" + column +
                ", base=" + base +
                ", suffixes=" + suffixes +
                '}';
    }

}
