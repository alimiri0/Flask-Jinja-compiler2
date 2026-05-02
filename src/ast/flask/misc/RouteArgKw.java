package ast.flask.misc;

import ast.flask.FlaskASTNode;
import ast.flask.expr.Expr;

public class RouteArgKw extends FlaskASTNode implements RouteArg {
    public final String name;
    public final Expr value;

    public RouteArgKw(String name, Expr value, int line, int column) {
        super(line, column);
        this.nodeName = "RouteArgKw";
        this.name = name;
        this.value = value;
        addChild(value);
    }

    @Override
    public String toString() {
        return "\nArg{ " +
                line + ":" + column +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
