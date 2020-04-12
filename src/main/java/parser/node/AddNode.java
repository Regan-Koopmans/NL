package parser.node;

import lexer.Token;

public class AddNode extends NodeWithValue {

    StringNode left;

    public StringNode getLeft() {
        return left;
    }

    public void setLeft(StringNode left) {
        this.left = left;
    }

    public StringNode getRight() {
        return right;
    }

    public void setRight(StringNode right) {
        this.right = right;
    }

    StringNode right;

    @Override
    public String getValue() {
        return left.getValue() + right.getValue();
    }

    @Override
    public void add(Token token) {
        if (left != null) {
            switch (token.getType()) {
                case STRING_LITERAL: right = new StringNode(token.getValue()); break;
            }
        }
    }
}
