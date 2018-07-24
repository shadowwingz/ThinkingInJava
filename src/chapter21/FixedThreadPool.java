package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shadowwingz on 2018-07-24 19:36
 */
public class FixedThreadPool {
    public static void main(String[] args) {
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