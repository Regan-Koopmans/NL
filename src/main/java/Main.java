import executor.Executor;
import lexer.Lexer;
import lexer.Token;
import parser.Parser;
import syntax.Statement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Executor executor = new Executor();
        List<Token> tokens;
        BufferedReader reader;
        boolean repl = false;

        if (args.length > 0) {
            reader = new BufferedReader(new FileReader(args[0]));
        } else {
            repl = true;
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String line;
        if (repl) {
            System.out.print("\n> ");
        }
        line = reader.readLine();
        while (line != null) {
            tokens = lexer.lex(line);

//            System.out.println("\nTokens\n------");
//            for (Token token : tokens) {
//                System.out.println(token.getType());
//            }

            assert tokens != null;
            List<Statement> statements = parser.parse(tokens);

            if (statements.isEmpty()) {
                System.out.println("\nVerklaring kan niet worden geparseerd\n");
            }  //                System.out.println("\nOutcome:");


            executor.execute(statements);
            if (repl) {
                System.out.print("> ");
            }
            line = reader.readLine();
        }
    }

}
