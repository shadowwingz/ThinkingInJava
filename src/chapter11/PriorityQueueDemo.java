package chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * Created by shadowwingz on 2018-06-18 21:15
 *
 * PriorityQueue 是优先级队列。它会根据 Comparable 接口的实现对队列中的元素进行排序，
 * 我们可以通过提供自己的 Comparator 来修改排序顺序。
 *
 * 当我们获取 PriorityQueue 中的元素时，获取的是队列中优先级最高的元素。
 *
 * Integer，String，Character 已经内置了自然排序（实现了 Comparable 接口），
 * 所以它们可以直接和 PriorityQueue 一起工作。
 * 如果我们想在 PriorityQueue 用自定义的类，就必须实现 Comparable 接口，
 * 这样 PriorityQueue 才会对元素进行排序。
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        /**
         * PriorityQueue 中是允许重复元素的，值越小，优先级越高
         * （如果是 String，空格也可以算作值，并且比字母的优先级高），
         * 先输出，
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        List<Integer> ints = Arrays.asList(
                25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 12, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        /**
         * 创建了一个反序的 PriorityQueue，在这个 PriorityQueue 中，
         * 值越大，优先级越高。
         *
         * 这也展示了，我们可以通过提供一个 Comparator 来
         * 改变 PriorityQueue 中元素的排序。
         */
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        System.out.println();

        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        System.out.println();

        /**
         * Set 中不储存重复元素
         */
        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            /**
             * char 自动装箱为 Character
             */
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}

/*
输出：

0 1 1 1 1 1 3 5 8 14
1 1 2 3 3 9 9 12 14 14 18 18 20 21 22 25 25
25 25 22 21 20 18 18 14 14 12 9 9 3 3 2 1 1
      A A B C C C D D E E E F H H I I L N N O O O O S S S T T U U U W
W U U U T T S S S O O O O N N L I I H H F E E E D D C C C B A A
  A B C D E F H I L N O S T U W

 */