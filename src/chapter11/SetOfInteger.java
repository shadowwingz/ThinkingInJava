package chapter11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by shadowwingz on 2018/6/18 0018.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        /**
         * Set 不保存重复的元素，所以在 0 到 29 之间的 10000 个随机数
         * 被添加到了 Set 中，每一个数都重复了很多次，
         * 但是每一个数只有一个实例出现在结果中
         */
        Set<Integer> intset = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}

/*
输出：

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]

 */
