package ast.flask.stmt;

import ast.flask.expr.Expr;

public class AssignStmt extends Stmt {
    public final String target;
    public final Expr value;

    public AssignStmt(String target, Expr value, int line, int column) {
        super(line, column);
        this.nodeName = "AssignStmt";
        this.target = target;
        this.value = value;
        addChild(value);
    }

    @Override
    public String toString() {
        return "\nAssignStmt{ " +
                line + ":" + column +
                ", target='" + target + '\'' +
                ", value=" + value +
                "}";
    }
}
