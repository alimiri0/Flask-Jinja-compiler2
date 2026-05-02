package ast.template.css.selector;

import ast.template.TemplateASTNode;

public class CssStarSelectorNode extends TemplateASTNode {

    public CssStarSelectorNode(int line, int column) {
        super(line, column);
        this.nodeName = "CssStarSelectorNode";
    }

    @Override
    public String toString() {
        return "\nCssStarSelectorNode{ " +
                line + ":" + column +
                '}';
    }
}
