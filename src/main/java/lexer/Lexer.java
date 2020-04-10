package lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> lex(String input) throws Exception {

        ArrayList<Token> tokens = new ArrayList<>();

        boolean inString = false;
        boolean inKeyword = false;

        String currentToken = "";
        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);
            if (inString) {
                if (current == '"') {
                    tokens.add(new Token(TokenType.STRING, 0, currentToken));
                    inString = false;
                } else {
                    currentToken += current;
                }

            } else if (inKeyword) {

                if (Character.isWhitespace(current)) {
                    if (currentToken.equals("schrijf")) {
                        tokens.add(new Token(TokenType.SCHRIJF, 0, ""));
                    } else {
                        tokens.add(new Token(TokenType.IDENTIFIER, 0, currentToken));
                    }
                    inKeyword = false;
                } else {
                    currentToken += current;
                }

            } else {

                if (!Character.isWhitespace(current)){
                    if (current == '"') {
                        inString = true;
                        currentToken = "";
                    } else {
                        inKeyword = true;
                        currentToken = String.format("%c", current);
                    }
                }
            }
        }
        return tokens;
    }
}
