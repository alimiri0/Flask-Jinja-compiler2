package ast.template.css.declaration;

public class CssNumberNode extends CssValueNode {
    public final String text;
    public CssNumberNode(String text, int line, int column) { super(line,column); this.nodeName = "CssNumberNode"; this.text = text; }

    @Override
    public String toString() {
        return "\nCssNumberNode{ " +
                line + ":" + column +
                ", text='" + text + '\'' +
                '}';
    }
}
