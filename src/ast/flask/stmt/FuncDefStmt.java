package ast.flask.stmt;

import ast.flask.misc.Param;
import java.util.List;

public class FuncDefStmt extends Stmt {
    public final String name;
    public final List<Param> params;
    public final List<Stmt> body;

    public FuncDefStmt(String name, List<Param> params, List<Stmt> body, int line, int column) {
        super(line, column);
        this.nodeName = "FuncDefStmt";
        this.name = name;
        this.params = params;
        this.body = body;
        for (Param p : params) addChild(p);
        for (Stmt s : body) addChild(s);
    }

    @Override
    public String toString() {
        return "\nFuncDefStmt{ " +
                line + ":" + column +
                ", name='" + name + '\'' +
                ", params=" + params +
                ", body=" + body +
                "}";
    }
}
