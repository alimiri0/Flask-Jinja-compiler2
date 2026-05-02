package ast.template.css.declaration;

public class CssStringNode extends CssValueNode {
    public final String text;
    public CssStringNode(String text, int line, int column) { super(line,column); this.nodeName = "CssStringNode"; this.text = text; }

    @Override
    public String toString() {
        return "\nCssStringNode{ " +
                line + ":" + column +
                ", text='" + text + '\'' +
                '}';
    }
}