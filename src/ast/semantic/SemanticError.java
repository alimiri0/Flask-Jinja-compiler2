package ast.semantic;

public class SemanticError {
    private final String errorType;
    private final String nodeName;
    private final int lineNumber;
    private final String message;

    public SemanticError(String errorType, String nodeName, int lineNumber, String message) {
        this.errorType = errorType;
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
        this.message = message;
    }

    public String getErrorType() { return errorType; }
    public String getNodeName() { return nodeName; }
    public int getLineNumber() { return lineNumber; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return String.format("[%-20s] %-20s at line %-4d %s",
                errorType, nodeName, lineNumber, message);
    }
}
