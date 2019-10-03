package chapter21;

/**
 * created by shadowwingz on 2019-10-03 15:09
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        // 1
        ++currentEvenValue;
        Thread.yield();
        // 2
        ++currentEvenValue;
        /**
         * 1 和 2 不是原子操作，也就是说，线程 A 执行了操作 1，
         * 可能接着 cpu 就去执行线程 B 了，
         * 这种情况下，数字就是奇数了。
         *
         * 在 1 和 2 中间加上 yield 就很明显了，线程 A 执行了操作 1，
         * 接着调用 yield，线程 1 会释放 cpu，接着 cpu 就去执行线程 B 了。
         */
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator());
    }
}
