package chapter5;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
public class ArrayNew {
    public static void main(String[] args) {
        int[] a;
        Random rand = new Random(47);
        a = new int[rand.nextInt(20)];
        // 如果创建数组时没有指定初值，那么数组元素中的基本类型会自动初始化成空值
        // 对于数字和字符，就是 0；对于布尔型，就是 false
        // 对于非基本类型，就是 null
        System.out.println("length of a = " + a.length);
        System.out.println(Arrays.toString(a));

        String[] s;
        s = new String[rand.nextInt(20)];
        System.out.println(Arrays.toString(s));
    }
}

/*
输出：

length of a = 18
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[null, null, null, null, null, null, null, null,
null, null, null, null, null, null, null]

 */
