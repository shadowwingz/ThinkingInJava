package chapter14;

import java.util.List;

import mindview.util.Null;

/**
 * Created by shadowwingz on 2018-07-05 20:35
 */
public interface Robot {

    String name();

    String model();

    List<Operation> operations();

    class Test {
        public static void test(Robot r) {
            if (r instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());
            for (Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
