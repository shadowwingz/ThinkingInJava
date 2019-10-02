package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by shadowwingz on 2018-07-26 20:45
 *
 * Daemon 是一个 Runnable 任务，它本身并不是线程。
 * Daemon 在后台线程中执行，在后台线程中又创建了子线程。
 * 在后台线程中创建的子线程也是后台线程。
 *
 * 在子线程中开启的子线程，并不是真正的子线程，
 * 它们是串行执行的。
 */
class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    @Override
    public void run() {
        // 第一个 for 循环
        for (int i = 0; i < t.length; i++) {
            /**
             * 在 Daemon 线程中产生的新线程也是 Daemon 的，即使没有 setDaemon(true)，
             * 这 10 个线程执行完毕，才会执行第二个 for 循环。
             */
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }
        // 第二个 for 循环
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}

/*
输出：

d.isDaemon() = true,
DaemonSpawn 0 started,
DaemonSpawn 1 started,
DaemonSpawn 2 started,
DaemonSpawn 3 started,
DaemonSpawn 4 started,
DaemonSpawn 5 started,
DaemonSpawn 6 started,
DaemonSpawn 7 started,
DaemonSpawn 8 started,
DaemonSpawn 9 started,
t[0].isDaemon() = true,
t[1].isDaemon() = true,
t[2].isDaemon() = true,
t[3].isDaemon() = true,
t[4].isDaemon() = true,
t[5].isDaemon() = true,
t[6].isDaemon() = true,
t[7].isDaemon() = true,
t[8].isDaemon() = true,
t[9].isDaemon() = true,

 */