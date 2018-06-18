package chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by shadowwingz on 2018-06-18 17:08
 *
 * offer 方法会将元素插入到队尾
 * Queue 队列是一个先进先出（FIFO）的容器
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);
        System.out.println();
        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }
}

/*
输出：

8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s

 */