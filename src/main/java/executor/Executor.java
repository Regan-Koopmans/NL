package executor;

import lexer.Token;
import syntax.Statement;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    public Executor() {

    }

    public void execute(List<Statement> statements) {

        for (Statement statement : statements) {
            statement.execute();
        }

    }

}
