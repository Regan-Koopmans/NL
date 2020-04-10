package lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private ArrayList<Token> tokens;
    private boolean inString = false;
    private boolean inKeyword = false;
    private String currentToken = "";

    public List<Token> lex(String input) throws Exception {

        tokens = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);
            if (inString) {
                inString(current);
            } else if (inKeyword) {
                inKeyword(current);
            } else {
                if (!Character.isWhitespace(current)) {
                    if (current == '"') {
                        inString = true;
                        currentToken = "";
                    } else if (current == '=') {
                      tokens.add(new Token(TokenType.ASSIGN, 0, null));
                    } else {
                        inKeyword = true;
                        currentToken = String.format("%c", current);
                    }
                }
            }
        }
        if (!currentToken.equals("")) {
            inKeyword(null);
        }

        return tokens;
    }

    private void inString(char current) {
        if (current == '"') {
            tokens.add(new Token(TokenType.STRING, 0, currentToken));
            inString = false;
        } else {
            currentToken += current;
        }
    }

    private void inKeyword(Character current) {
        if (current == null || Character.isWhitespace(current)) {
            if (currentToken.equals("schrijfn")) {
                tokens.add(new Token(TokenType.SCHRIJFN, 0, null));
            } else if (currentToken.equals("schrijf")) {
                tokens.add(new Token(TokenType.SCHRIJF, 0, null));
            } else if (isNumeric(currentToken)) {

                tokens.add(new Token(TokenType.NUMBER, 0, currentToken));
            } else {

                tokens.add(new Token(TokenType.IDENTIFIER, 0, currentToken));
            }
            inKeyword = false;
        } else {
            currentToken += current;
        }
    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
