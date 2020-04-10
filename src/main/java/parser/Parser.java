package parser;

import lexer.Token;
import lexer.TokenType;
import syntax.SchrijfStatement;
import syntax.Statement;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<Token> stack;

    public List<Statement> parse(List<Token> tokens) {

        this.stack = new ArrayList<>();
        List<Statement> statements = new ArrayList<>();
        for (Token token : tokens) {
            stack.add(token);
            Statement statement = checkForStatement();
            if (statement != null)
                statements.add(statement);
        }

        return statements;
    }

    private Statement checkForStatement() {
        Statement statement = null;

        if (stack.size() == 2) {
            TokenType first = stack.get(0).getType();
            TokenType second = stack.get(1).getType();

            if (first == TokenType.SCHRIJF &&
                    (second == TokenType.STRING || second == TokenType.NUMBER)) {
                statement = new SchrijfStatement(stack.get(1).getValue());
                stack.clear();
            }
        }

        return statement;
    }

}
