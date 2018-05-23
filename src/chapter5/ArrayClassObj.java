package chapter5;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
public class ArrayClassObj {
    public static void main(String[] args) {
        Random rand = new Random(47);
        // 这里只是创建了一个引用数组
        Integer[] a = new Integer[rand.nextInt(20)];
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            // rand.nextInt 创建一个 int，然后 int 自动装箱成 Integer
            // Integer 再赋值给 in[i]，这时数组的元素才有值。
            // 数组才算真正的被创建
            a[i] = rand.nextInt(500);
        }
        System.out.println(Arrays.toString(a));
    }
}
