package chapter21;

/**
 * created by shadowwingz on 2019-10-02 21:09
 */
class UnResponsiveUI {

    private volatile double d = 1;

    public UnResponsiveUI() throws Exception {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        // 执行不到这里
        System.in.read();
    }

    public static void main(String[] args) {

    }
}

public class ResponsiveUI extends Thread {

    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
        /**
         * UnResponsiveUI 运行在 main 线程上，
         * 由于代码会一直执行 while 语句，所以程序会
         * 一直卡在 UnResponsiveUI 的 while 语句中，
         * main 线程会阻塞。
         */
//        new UnResponsiveUI();
        /**
         * ResponsiveUI 继承自 Thread，所以 ResponsiveUI 会开启一个子线程，
         * 即使子线程一直执行 while 语句，也只阻塞子线程，不会阻塞 main 线程。
         */
        new ResponsiveUI();
        System.in.read();
        // 当获取到用户输入后，会打印 d，然后 main 线程结束运行，
        // main 线程结束运行后，后台线程也会被杀掉。
        System.out.println(d);
    }
}