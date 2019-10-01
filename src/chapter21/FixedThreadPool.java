package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shadowwingz on 2018-07-24 19:36
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        /**
         * newFixedThreadPool 会创建一次性创建几个线程，即使要执行的任务只有一个，也会创建几个线程。
         * 具体是几个线程，要看传入构造方法的数量。
         *
         * 创建完线程后，线程执行完任务之后不会销毁，而是会等待其他任务。所以如果有其他任务需要
         * 执行，不需要再重新创建线程，直接用线程池中的线程就可以了。
         *
         * 好处：不用为每个任务都创建一个线程，节省时间和空间，可以复用线程池中的线程。
         * 坏处：刚开始创建的时候，可能会出现线程数量大于任务数量，造成浪费。
         */
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

/*
输出：

#2(9), #0(9), #2(8), #1(9), #2(7), #2(6), #3(9), #2(5), #0(8),
#2(4), #2(3), #4(9), #2(2), #3(8), #1(8), #0(7), #2(1), #1(7),
#4(8), #2(LiftOff!), #3(7), #4(7), #1(6), #0(6), #3(6), #1(5),
#3(5), #4(6), #3(4), #1(4), #0(5), #1(3), #3(3), #4(5), #3(2),
#1(2), #0(4), #1(1), #3(1), #4(4), #3(LiftOff!), #1(LiftOff!),
#0(3), #4(3), #0(2), #4(2), #0(1), #4(1), #0(LiftOff!), #4(LiftOff!),

 */