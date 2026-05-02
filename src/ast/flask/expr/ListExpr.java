package ast.flask.expr;

import java.util.List;

public class ListExpr extends Expr {
    public final List<Expr> elements;

    public ListExpr(List<Expr> elements, int line, int column) {
        super(line, column);
        this.nodeName = "ListExpr";
        this.elements = elements;
        for (Expr e : elements) addChild(e);
    }

    @Override
    public String toString() {
        return "\nListExpr{ " +
                line + ":" + column +
                ", elements=" + elements +
                '}';
    }

}
