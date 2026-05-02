package ast.template;

import java.util.List;

public class TemplateHtmlTagNode extends TemplateElementNode {
    public final String tagName;
    public final TemplateTagWithContentNode tagContent;

    public TemplateHtmlTagNode(
            String tagName,
            TemplateTagWithContentNode tagContent,
            List<TemplateASTNode> childNodes,
            int line,
            int column
    ) {
        super(line, column);
        this.nodeName = "TemplateHtmlTagNode";
        this.tagName = tagName;
        this.tagContent = tagContent;
        this.children.addAll(childNodes);
    }

    @Override
    public String toString() {
        String tagAttrsSting = "";
        if(!tagContent.attrs.isEmpty())
            tagAttrsSting = ", tagAttrs = " + tagContent;
        return "\nTemplateHtmlTagNode{ " +
                line + ":" + column +
                ", tagName='" + tagName + '\'' +
                tagAttrsSting +
                ", tagContent=" + children +
                '}';
    }
}
