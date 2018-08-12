package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by shadowwingz on 2018-07-25 17:10
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        /**
         * 这里让 main 线程睡眠 175 毫秒，所以前面的子线程才能执行，
         * 否则，如果 main 线程不睡眠，main 线程很快就执行完了，
         * main 线程一执行完，程序就结束了。前面的子线程会来不及执行。
         */
        TimeUnit.MILLISECONDS.sleep(175);
    }
}

/*
输出：

All daemons started
Thread[Thread-3,5,main] chapter21.SimpleDaemons@13f938d6
Thread[Thread-4,5,main] chapter21.SimpleDaemons@2f5aff2b
Thread[Thread-6,5,main] chapter21.SimpleDaemons@789b4b3a
Thread[Thread-1,5,main] chapter21.SimpleDaemons@4bd9391d
Thread[Thread-7,5,main] chapter21.SimpleDaemons@36bdb2aa
Thread[Thread-2,5,main] chapter21.SimpleDaemons@5247863c
Thread[Thread-9,5,main] chapter21.SimpleDaemons@60cb300b
Thread[Thread-8,5,main] chapter21.SimpleDaemons@f2733ba
Thread[Thread-5,5,main] chapter21.SimpleDaemons@59e72e28
Thread[Thread-0,5,main] chapter21.SimpleDaemons@d001520

 */