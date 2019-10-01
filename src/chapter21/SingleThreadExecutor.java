package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shadowwingz on 2018-07-24 19:41
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        /**
         * newSingleThreadExecutor 是一个只有一个线程的线程池。
         * 即使有多个任务被丢到这个线程池，任务会依次排队执行。
         */
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

/*
输出：

#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(LiftOff!),
#1(9), #1(8), #1(7), #1(6), #1(5), #1(4), #1(3), #1(2), #1(1), #1(LiftOff!),
#2(9), #2(8), #2(7), #2(6), #2(5), #2(4), #2(3), #2(2), #2(1), #2(LiftOff!),
#3(9), #3(8), #3(7), #3(6), #3(5), #3(4), #3(3), #3(2), #3(1), #3(LiftOff!),
#4(9), #4(8), #4(7), #4(6), #4(5), #4(4), #4(3), #4(2), #4(1), #4(LiftOff!),

 */