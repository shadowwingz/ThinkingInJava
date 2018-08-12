package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import mindview.util.DaemonThreadFactory;

/**
 * Created by shadowwingz on 2018-07-25 20:47
 */
public class DaemonFromFactory implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * DaemonThreadFactory 对象用来创建新的线程，
         * DaemonFromFactory 定义了要执行的任务。
         */
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

/*
输出：

All daemons started
Thread[Thread-4,5,main] chapter21.DaemonFromFactory@70d192f2
Thread[Thread-2,5,main] chapter21.DaemonFromFactory@7510bd5c
Thread[Thread-7,5,main] chapter21.DaemonFromFactory@3d3e384b
Thread[Thread-6,5,main] chapter21.DaemonFromFactory@3c494859
Thread[Thread-1,5,main] chapter21.DaemonFromFactory@d0204ed
Thread[Thread-5,5,main] chapter21.DaemonFromFactory@4c6aca09
Thread[Thread-0,5,main] chapter21.DaemonFromFactory@7d3063e9
Thread[Thread-3,5,main] chapter21.DaemonFromFactory@7aa3aa20
Thread[Thread-9,5,main] chapter21.DaemonFromFactory@a83d201
Thread[Thread-8,5,main] chapter21.DaemonFromFactory@654e4f0e
Thread[Thread-0,5,main] chapter21.DaemonFromFactory@7d3063e9
Thread[Thread-6,5,main] chapter21.DaemonFromFactory@3c494859
Thread[Thread-2,5,main] chapter21.DaemonFromFactory@7510bd5c
Thread[Thread-1,5,main] chapter21.DaemonFromFactory@d0204ed
Thread[Thread-4,5,main] chapter21.DaemonFromFactory@70d192f2
Thread[Thread-7,5,main] chapter21.DaemonFromFactory@3d3e384b
Thread[Thread-3,5,main] chapter21.DaemonFromFactory@7aa3aa20
Thread[Thread-5,5,main] chapter21.DaemonFromFactory@4c6aca09
Thread[Thread-8,5,main] chapter21.DaemonFromFactory@654e4f0e
Thread[Thread-9,5,main] chapter21.DaemonFromFactory@a83d201
Thread[Thread-5,5,main] chapter21.DaemonFromFactory@4c6aca09
Thread[Thread-2,5,main] chapter21.DaemonFromFactory@7510bd5c
Thread[Thread-1,5,main] chapter21.DaemonFromFactory@d0204ed
Thread[Thread-6,5,main] chapter21.DaemonFromFactory@3c494859
Thread[Thread-7,5,main] chapter21.DaemonFromFactory@3d3e384b
Thread[Thread-3,5,main] chapter21.DaemonFromFactory@7aa3aa20
Thread[Thread-0,5,main] chapter21.DaemonFromFactory@7d3063e9
Thread[Thread-4,5,main] chapter21.DaemonFromFactory@70d192f2
Thread[Thread-9,5,main] chapter21.DaemonFromFactory@a83d201
Thread[Thread-8,5,main] chapter21.DaemonFromFactory@654e4f0e
Thread[Thread-2,5,main] chapter21.DaemonFromFactory@7510bd5c
Thread[Thread-3,5,main] chapter21.DaemonFromFactory@7aa3aa20
Thread[Thread-5,5,main] chapter21.DaemonFromFactory@4c6aca09
Thread[Thread-6,5,main] chapter21.DaemonFromFactory@3c494859
Thread[Thread-7,5,main] chapter21.DaemonFromFactory@3d3e384b
Thread[Thread-1,5,main] chapter21.DaemonFromFactory@d0204ed
Thread[Thread-4,5,main] chapter21.DaemonFromFactory@70d192f2
Thread[Thread-0,5,main] chapter21.DaemonFromFactory@7d3063e9
Thread[Thread-8,5,main] chapter21.DaemonFromFactory@654e4f0e
Thread[Thread-9,5,main] chapter21.DaemonFromFactory@a83d201

 */