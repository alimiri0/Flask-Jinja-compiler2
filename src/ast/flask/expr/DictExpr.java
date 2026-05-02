package ast.flask.expr;

import ast.flask.misc.DictPair;

import java.util.List;

public class DictExpr extends Expr {
    public final List<DictPair> pairs;

    public DictExpr(List<DictPair> pairs, int line, int column) {
        super(line, column);
        this.nodeName = "DictExpr";
        this.pairs = pairs;
        for (DictPair p : pairs) addChild(p);
    }

    @Override
    public String toString() {
        return "\nDictExpr{ " +
                line + ":" + column +
                ", pairs=" + pairs +
                '}';
    }
}
