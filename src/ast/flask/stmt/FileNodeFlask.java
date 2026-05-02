package ast.flask.stmt;

import java.util.List;

public class FileNodeFlask extends Stmt {
    public final List<Stmt> statements;

    public FileNodeFlask(List<Stmt> statements, int line, int column) {
        super(line, column);
        this.nodeName = "FileNodeFlask";
        this.statements = statements;
        for (Stmt s : statements) addChild(s);
    }

    @Override
    public String toString() {
        return "\nFileNode{ " +
                line + ":" + column +
                ", statements=" + statements +
                "}";
    }
}
