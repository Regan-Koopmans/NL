import executor.Executor;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
import lexer.Lexer;
import lexer.Token;
import parser.Parser;
import parser.SyntaxTree;
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
            assert tokens != null;
            SyntaxTree tree = parser.parse(tokens);
            executor.execute(tree);
            if (repl) {
                System.out.print("> ");
            }
            line = reader.readLine();
        }
    }

}
