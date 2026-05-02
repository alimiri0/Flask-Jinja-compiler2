package ast.flask.stmt;

import ast.flask.expr.Expr;
import java.util.List;

public class IfStmt extends Stmt {
    public final Expr condition;
    public final List<Stmt> body;

    public IfStmt(Expr condition, List<Stmt> body, int line, int column) {
        super(line, column);
        this.nodeName = "IfStmt";
        this.condition = condition;
        this.body = body;
        addChild(condition);
        for (Stmt s : body) addChild(s);
    }

    @Override
    public String toString() {
        return "\nIfStmt{ " +
                line + ":" + column +
                ", condition=" + condition +
                ", body=" + body +
                "}";
    }
}
