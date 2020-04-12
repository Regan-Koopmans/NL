package parser;

import lexer.Token;
import parser.node.ExecutableNode;
import parser.node.SchrijfnNode;
import syntax.TokenType;

public class SyntaxTree {

    ExecutableNode root;

    public ExecutableNode getRoot() {
        return root;
    }

    public void setRoot(ExecutableNode root) {
        this.root = root;
    }

    public void add(Token token) {
        if (root == null) {
            if (token.getType() == TokenType.SCHRIJFN) {
                setRoot(new SchrijfnNode());
            }
            return;
        }

        root.add(token);

    }
}
