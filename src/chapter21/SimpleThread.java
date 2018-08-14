package chapter21;

/**
 * Created by shadowwingz on 2018-07-28 16:06
 *
 * 最简单的创建线程的方法，继承 Thread 类，再调用 start 方法。
 */
public class SimpleThread extends Thread {

    private int countDown = 5;

    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}

/*
输出：

#1(5), #4(5), #5(5), #3(5), #3(4), #3(3), #3(2),
#2(5), #3(1), #5(4), #4(4), #1(4), #4(3), #5(3),
#4(2), #2(4), #2(3), #2(2), #2(1), #4(1), #5(2),
#5(1), #1(3), #1(2), #1(1),

 */