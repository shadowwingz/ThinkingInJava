package chapter21;

/**
 * created by shadowwingz on 2019-10-02 17:46
 */
class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            /**
             * 当 Sleeper 被中断时，会进入 catch 语句，
             * 这时理论上 Sleeper 的 isInterrupted 应该是 true，
             * 但是因为异常被捕获时将清理这个标志，所以在 catch 语句中，
             * isInterrupted 总是返回 false。
             */
            System.out.println(getName() + " was interrupted, " + "isInterrupted(): " + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {

    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            // 在 Joiner 线程调用 sleeper.join
            // 当 sleeper 的 run 方法执行完毕后，
            // Joiner 的 run 方法会继续执行。
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}

/*

输出：

[在 main 中，调用 grumpy.interrupt() 方法，会中断线程，Grumpy 线程进入 catch 语句]
Grumpy was interrupted, isInterrupted(): false
Grumpy has awakened
[Doc 线程等待 Grumpy 线程执行完毕，再继续执行]
Doc join completed
[Sleepy 没有进入 catch 语句]
Sleepy has awakened
[Dopey 线程等待 Sleepy 线程执行完毕，再继续执行]
Dopey join completed

 */