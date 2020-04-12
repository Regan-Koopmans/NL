package executor;

import parser.SyntaxTree;

public class Executor {

    private NameTable table;

    public Executor() {

    }

    public void execute(SyntaxTree tree) {

        tree.getRoot().execute();


    }
}
