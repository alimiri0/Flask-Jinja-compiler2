package ast.flask.stmt;

import ast.flask.expr.Expr;

public class ExprStmt extends Stmt {
    public final Expr expr;

    public ExprStmt(Expr expr, int line, int column) {
        super(line, column);
        this.nodeName = "ExprStmt";
        this.expr = expr;
        addChild(expr);
    }

    @Override
    public String toString() {
        return "\nExprStmt{ " +
                line + ":" + column +
                ", expr=" + expr +
                "}";
    }
}
