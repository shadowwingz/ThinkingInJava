package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shadowwingz on 2018-07-24 20:27
 *
 * 线程的优先级将该线程的重要性传递给了调度器。
 * 尽管 CPU 处理现有线程集的顺序是不确定的，
 * 但是调度器将倾向于让优先级最高的线程先执行。
 * 但是，这并不是说，优先级较低的线程将得不到执行，
 * 优先级较低的线程只是执行的频率较低。
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            /**
             * 执行了 100000 次的浮点运算，这里要保证运算时间足够的长，
             * 线程调用机制才来得及介入，设置优先级才有效果。
             */
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 前 5 个任务都是低优先级
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        /**
         * 第 6 个任务是高优先级
         *
         * 高优先级的任务虽然是后面才提交给线程池的，
         * 但是执行的时候，高优先级的任务是优先被执行的。
         */
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

/*
输出：

Thread[pool-1-thread-1,1,main]: 5
Thread[pool-1-thread-4,1,main]: 5
Thread[pool-1-thread-6,10,main]: 5
Thread[pool-1-thread-5,1,main]: 5
Thread[pool-1-thread-3,1,main]: 5
Thread[pool-1-thread-5,1,main]: 4
Thread[pool-1-thread-2,1,main]: 5
Thread[pool-1-thread-1,1,main]: 4
Thread[pool-1-thread-6,10,main]: 4
Thread[pool-1-thread-5,1,main]: 3
Thread[pool-1-thread-4,1,main]: 4
Thread[pool-1-thread-2,1,main]: 4
Thread[pool-1-thread-1,1,main]: 3
Thread[pool-1-thread-3,1,main]: 4
Thread[pool-1-thread-6,10,main]: 3
Thread[pool-1-thread-2,1,main]: 3
Thread[pool-1-thread-4,1,main]: 3
Thread[pool-1-thread-5,1,main]: 2
Thread[pool-1-thread-1,1,main]: 2
Thread[pool-1-thread-3,1,main]: 3
Thread[pool-1-thread-2,1,main]: 2
Thread[pool-1-thread-6,10,main]: 2
Thread[pool-1-thread-4,1,main]: 2
Thread[pool-1-thread-5,1,main]: 1
Thread[pool-1-thread-3,1,main]: 2
Thread[pool-1-thread-1,1,main]: 1
Thread[pool-1-thread-6,10,main]: 1
Thread[pool-1-thread-2,1,main]: 1
Thread[pool-1-thread-3,1,main]: 1
Thread[pool-1-thread-4,1,main]: 1

 */