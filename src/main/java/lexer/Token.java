package lexer;

public class Token {

    private TokenType type;
    private long lineNumber;
    private String value;

    public Token(TokenType type, long lineNumber, String value) {
        this.type = type;
        this.lineNumber = lineNumber;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(long lineNumber) {
        this.lineNumber = lineNumber;
    }
}
