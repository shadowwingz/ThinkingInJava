package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * created by shadowwingz on 2019-10-03 11:14
 */
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        System.out.println("====== 我是分割线 ======");
        /**
         * 这里抛出的异常，不会导致程序报错，因为异常被
         * MyUncaughtExceptionHandler 捕获了。
         */
        throw new RuntimeException();
    }
}

/**
 * MyUncaughtExceptionHandler 要通过 Thread.setUncaughtExceptionHandler 设置给线程，
 * 线程抛异常的时候，异常才能被 MyUncaughtExceptionHandler 捕获。
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
        System.out.println("====== 我是分割线 ======");
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh " + t.getUncaughtExceptionHandler());
        System.out.println("====== 我是分割线 ======");
        return t;
    }
}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        /**
         * 将 HandlerThreadFactory 设置给线程池，
         * 线程池创建出的线程就默认是设置了 MyUncaughtExceptionHandler。
         */
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
