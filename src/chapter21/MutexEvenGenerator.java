package chapter21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by shadowwingz on 2019-10-04 13:22
 */
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        // ThreadA 调用 lock 方法，next 就被锁定了，ThreadB 会在这里阻塞。
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            /**
             * return 语句要在 try 里面，这样能保证 currentEvenValue 一定会返回给 ThreadA，
             * 如果写在 try 的后面，就可能出现，调用 unlock 之后，ThreadA 还没
             * 取走 currentEvenValue 就阻塞了，ThreadB 执行到这里，取走了 currentEvenValue。
             */
            return currentEvenValue;
        } finally {
            /**
             * Lock 和 try finally 配合使用效果更佳，一旦出现异常，可以在 finally 中补救，
             * 做一些清理工作，如果是用 synchronized，一旦出现异常，就无法补救。
             */
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventChecker.test(new MutexEvenGenerator());
    }
}
