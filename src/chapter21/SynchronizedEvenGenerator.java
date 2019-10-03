package chapter21;

/**
 * created by shadowwingz on 2019-10-03 22:55
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        // 1
        ++currentEvenValue;
        /**
         * yield 是线程让步，让出 cpu 使用权，
         * 但是无法保证让步的目的。
         * 也就是说，线程 A 执行了 yield，本来是想让线程 B 执行的，
         * 但是由于 next 方法加锁，所以线程 B 无法调用 next 方法，
         * 过了一段时间，cpu 又轮到线程 A 使用了。
         */
        Thread.yield();
        // 2
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedEvenGenerator());
    }
}
