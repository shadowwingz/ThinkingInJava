package chapter21;

/**
 * Created by shadowwingz on 2018-07-24 16:38
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}

/*
输出：

Waiting for LiftOff
#2(9), #0(9), #2(8), #1(9), #3(9), #4(9), #2(7), #0(8), #3(8),
#4(8), #2(6), #0(7), #1(8), #0(6), #2(5), #4(7), #3(7), #4(6),
#2(4), #0(5), #1(7), #2(3), #4(5), #3(6), #4(4), #2(2), #1(6),
#0(4), #1(5), #2(1), #4(3), #3(5), #4(2), #3(4), #2(LiftOff!),
#1(4), #0(3), #1(3), #3(3), #4(1), #3(2), #1(2), #3(1), #0(2),
#3(LiftOff!), #1(1), #4(LiftOff!), #1(LiftOff!), #0(1), #0(LiftOff!),

 */