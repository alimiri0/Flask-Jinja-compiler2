package ast.template;

public class AttrJinjaVarNode extends QuotedItemNode{
    public final TemplateJinjaVarNode var;

    public AttrJinjaVarNode(TemplateJinjaVarNode var) {
        super(var.line, var.column);
        this.nodeName = "AttrJinjaVarNode";
        this.var = var;
    }

    @Override
    public String toString() {
        return  var.toString();
    }
}
