package chapter21;

/**
 * Created by shadowwingz on 2018-07-24 11:43
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    /**
     * 标识符 id 用来区分任务
     */
    private final int id = taskCount++;

    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    /**
     * 当一个类实现了 Runnable 接口时，必须实现 run 方法。
     * 但是 run 方法并不一定是运行在子线程，也可能运行在主线程。
     * 换句话说，run 方法和线程没关系。
     */
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            /**
             * 调用 Thread.yield 是对线程调度器（ Java 线程机制的一部分，
             * 可以将 CPU 从一个线程转移给另一个线程）的一个建议，它表示：
             * 我已经做了我要做的事了，现在可以让别的任务执行了。
             */
            Thread.yield();
        }
    }
}