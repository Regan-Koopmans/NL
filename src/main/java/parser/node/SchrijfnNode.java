package parser.node;

import lexer.Token;
import syntax.TokenType;

public class SchrijfnNode extends ExecutableNode {

    NodeWithValue child;

    public NodeWithValue getChild() {
        return child;
    }

    public void setChild(NodeWithValue child) {
        this.child = child;
    }

    @Override
    public void add(Token token) {

        if (child == null && token.getType() == TokenType.STRING_LITERAL) {
            setChild(new StringNode(token.getValue()));
            return;
        }

        if (token.getType() == TokenType.ADD) {

            StringNode child = (StringNode) getChild();
            AddNode addNode = new AddNode();
            addNode.setLeft(child);
            setChild(addNode);

            return;
        }

        getChild().add(token);
    }

    @Override
    public void execute() {
        System.out.println(child.getValue());
    }
}
