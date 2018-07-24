package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by shadowwingz on 2018-07-24 20:09
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                // 以前的写法
//                Thread.sleep(100);
                // 新写法，可以指定 sleep 延迟的时间单元，这里指定的毫秒
                /**
                 * 每次 sleep 之后，任务都会睡眠（即阻塞）,这使得线程调度器
                 * 可以切换到另一个线程，去执行另一个任务。
                 */
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}

/*
输出：

#2(9), #3(9), #4(9), #1(9), #0(9), #4(8), #1(8), #0(8), #3(8), #2(8),
#2(7), #4(7), #1(7), #0(7), #3(7), #2(6), #0(6), #1(6), #4(6), #3(6),
#0(5), #2(5), #1(5), #3(5), #4(5), #1(4), #0(4), #4(4), #3(4), #2(4),
#1(3), #3(3), #0(3), #2(3), #4(3), #2(2), #3(2), #0(2), #1(2), #4(2),
#0(1), #1(1), #2(1), #3(1), #4(1), #4(LiftOff!), #1(LiftOff!), #0(LiftOff!),
#2(LiftOff!), #3(LiftOff!),

 */