package chapter11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        /**
         * 这里的 ArrayList 可以替换为其他容器类，
         * 只要是实现了 Collection 接口的类。
         */
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            /**
             * add 方法是 Collection 接口的方法
             */
            c.add(i);
        }
        /**
         * Collection 接口继承了 Iterable 接口，
         * 所以可以用 foreach 语法遍历。
         */
        for (Integer i : c) {
            System.out.print(i + ", ");
        }
    }
}

/*
输出：

0, 1, 2, 3, 4, 5, 6, 7, 8, 9,

 */