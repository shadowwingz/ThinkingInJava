package chapter21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by shadowwingz on 2019-10-04 13:37
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        /**
         * 获取锁，获取之后立即返回，不会阻塞，
         * 能获取到就返回 true，否则返回 false。
         */
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            /**
             * 带时间限制的 tryLock，拿不到锁，就等 2 秒，
             * 超时返回 false。
             */
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                // 后台线程持有锁
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        /**
         * 主线程睡眠 1 秒钟，确保子线程的 al.lock.lock()
         * 比 al.untimed() 先执行，先获取到锁。
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 由于子线程持有锁，主线程获取锁失败。
         */
        al.untimed();
        al.timed();
    }
}
