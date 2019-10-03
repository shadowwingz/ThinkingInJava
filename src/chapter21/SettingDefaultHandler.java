package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by shadowwingz on 2019-10-03 11:58
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        /**
         * 通过 setDefaultUncaughtExceptionHandler 静态方法给 Thread 设置异常处理器，
         * 程序中所有的线程的异常都可以被捕获。
         */
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
