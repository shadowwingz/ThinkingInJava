package chapter11;

import java.util.Arrays;

/**
 * Created by shadowwingz on 2018-06-18 23:05
 *
 * foreach 可以用于数组或其他任何 Iterable，
 * 但是这并不是说数组就一定是 Iterable。
 */
public class ArrayIsNotIterable {

    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        System.out.println();
        String[] strings = {"A", "B", "C"};
        /**
         * String 数组并不是 Iterable，所以不能传入 test 方法。
         */
//        test(strings);
        /**
         * 把 String 数组转换成 List，
         * List 是 Iterable，这时就可以传入 test 方法。
         */
        test(Arrays.asList(strings));
    }
}

/*
输出：

1 2 3
A B C

 */