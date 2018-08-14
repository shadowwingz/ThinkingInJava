package chapter21;

/**
 * Created by shadowwingz on 2018-08-14 10:00
 * <p>
 * 第二种创建线程的方法，实现 Runnable 接口，再把类传入 Thread 类的构造器中。
 * <p>
 * 注意：实现 Runnable 接口，只是表明它是一个可以调用的任务，并不是已经创建了线程。
 * new Thread 才是创建线程。
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;

    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
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
            new SelfManaged();
        }
    }
}

/*
输出：

Thread-2(5)Thread-3(5)Thread-4(5)Thread-0(5)Thread-1(5)Thread-0(4)
Thread-0(3)Thread-0(2)Thread-4(4)Thread-3(4)Thread-2(4)Thread-3(3)
Thread-4(3)Thread-0(1)Thread-1(4)Thread-4(2)Thread-3(2)Thread-2(3)
Thread-3(1)Thread-2(2)Thread-4(1)Thread-1(3)Thread-2(1)Thread-1(2)
Thread-1(1)

 */