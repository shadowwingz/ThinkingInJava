package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by shadowwingz on 2019-10-02 21:24
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        // 在线程中抛出异常无法被捕获
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
