package ast.flask.expr;

public class IndexExpr extends Expr {
    public final Expr index;

    public IndexExpr(Expr index, int line, int column) {
        super(line, column);
        this.nodeName = "IndexExpr";
        this.index = index;
        addChild(index);
    }

    @Override
    public String toString() {
        return "\nIndexExpr{ " +
                line + ":" + column +
                ", index=" + index +
                '}';
    }
}
