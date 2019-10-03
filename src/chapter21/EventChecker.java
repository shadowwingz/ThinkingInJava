package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by shadowwingz on 2019-10-03 14:33
 */
public class EventChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EventChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " 不是偶数!");
                generator.cancel();
            } else {
                System.out.println(val + " 是偶数");
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EventChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

//    public static void main(String[] args) {
//        test(new IntGenerator() {
//            @Override
//            public int next() {
//                return new Random().nextInt(10);
////                return 2;
//            }
//        });
//    }
}
