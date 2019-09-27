package chapter20;

public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    void testExecute() {
        execute();
    }

    public static void main(String[] args) {
        Testable testable = new Testable();
        testable.testExecute();
    }
}
