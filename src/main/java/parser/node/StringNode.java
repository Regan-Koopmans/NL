package parser.node;

import lexer.Token;

public class StringNode extends NodeWithValue {

    String value;

    StringNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void add(Token token) {

    }
}
