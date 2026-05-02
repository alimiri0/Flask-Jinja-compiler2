package ast.flask.expr;

import ast.flask.misc.ArgKw;

import java.util.List;

public class CallExpr extends Expr {
    public final List<ArgKw> routeArgKws;

    public CallExpr(List<ArgKw> routeArgKws, int line, int column) {
        super(line, column);
        this.nodeName = "CallExpr";
        this.routeArgKws = routeArgKws;
        for (ArgKw a : routeArgKws) addChild(a);
    }

    @Override
    public String toString() {
        return "\nCallExpr{ " +
                line + ":" + column +
                ", args=" + routeArgKws +
                '}';
    }
}
