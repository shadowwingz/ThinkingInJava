package chapter5;

import java.util.Arrays;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3, // 自动装箱为 Integer
        };

        Integer[] b = new Integer[]{
                new Integer(1),
                new Integer(2),
                3,
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
