package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shadowwingz on 2018-07-24 17:50
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        /**
         * 调用 shutdown 方法可以防止新任务被提交给线程池
         */
        exec.shutdown();
    }
}

/*
输出：

#1(9), #2(9), #0(9), #3(9), #4(9), #0(8), #2(8), #1(8), #2(7),
#0(7), #4(8), #3(8), #4(7), #0(6), #2(6), #1(7), #2(5), #0(5),
#4(6), #3(7), #4(5), #0(4), #2(4), #1(6), #2(3), #0(3), #4(4),
#3(6), #4(3), #0(2), #2(2), #1(5), #2(1), #1(4), #0(1), #4(2),
#3(5), #3(4), #4(1), #0(LiftOff!), #1(3), #2(LiftOff!), #1(2),
#4(LiftOff!), #3(3), #1(1), #3(2), #3(1), #1(LiftOff!), #3(LiftOff!),

 */