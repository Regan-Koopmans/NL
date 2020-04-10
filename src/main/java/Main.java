import executor.Executor;
import lexer.Lexer;
import lexer.Token;
import parser.Parser;
import syntax.Statement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Executor executor = new Executor();
        List<Token> tokens;
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String line;
        line = reader.readLine();
        while (line != null) {
            tokens = lexer.lex(line);
            assert tokens != null;
            List<Statement> statements = parser.parse(tokens);
            executor.execute(statements);
            line = reader.readLine();
        }
    }

}
