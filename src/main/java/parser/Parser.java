package parser;

import lexer.Token;

import java.util.List;

public class Parser {

    public SyntaxTree parse(List<Token> tokens) {
        SyntaxTree tree = new SyntaxTree();

        for (Token token : tokens) {
            tree.add(token);
        }

        return tree;
    }
}
