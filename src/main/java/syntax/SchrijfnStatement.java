package syntax;

public class SchrijfnStatement extends Statement {

    private String value;

    public SchrijfnStatement(String value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println(value);
    }
}
