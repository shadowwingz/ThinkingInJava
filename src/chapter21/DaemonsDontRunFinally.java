package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by shadowwingz on 2018-07-27 19:53
 */
class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            // 如果 ADaemon 被后台线程执行，那么 finally 语句不一定可以执行。
            // 在时间来不及的情况下，比如 main 线程死掉，那么 finally 语句不会执行。
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        /**
         * https://blog.csdn.net/xyls12345/article/details/26256693
         *
         * java 中线程分为两种类型：用户线程和守护线程。
         * 通过 Thread.setDaemon(false) 设置为用户线程；
         * 通过 Thread.setDaemon(true) 设置为守护线程。
         * 如果不设置此属性，默认为用户线程。
         *
         * 当 t.start() 这句执行完的时候，主线程已经结束了，如果此时还有用户线程，
         * 那就等用户线程执行完，程序结束，如果只有守护线程，那就直接结束。
         */
        t.start();
        // 主线程休眠 2 秒，后台线程的 finally 语句才可以执行。
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

/*
输出：

Starting ADaemon

 */