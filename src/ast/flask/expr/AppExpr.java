package ast.flask.expr;

public class AppExpr extends Expr {

    public AppExpr(int line, int column) {
        super(line, column);
        this.nodeName = "AppExpr";
    }

    @Override
    public String toString() {
        return "\nAppExpr{ " +
                line + ":" + column +
                '}';
    }
}
