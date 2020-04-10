package syntax;

public class SchrijfStatement extends Statement {

    private String value;

    public SchrijfStatement(String value) {
        this.value = value;
    }

    @Override
    public void execute() {
        System.out.println(value);
    }
}
