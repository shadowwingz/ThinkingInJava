package chapter13;

/**
 * Created by shadowwingz on 2018-06-24 22:03
 *
 * Immutable 不变
 *
 * String 对象是不可变的，String 类中每一个看起来
 * 会修改 String 值的方法，比如 toUpperCase()，
 * 实际上都是创建了一个全新的 String 对象。
 */
public class Immutable {

    /**
     * upcase 返回的引用已经指向了一个新的对象 HOWDY
     */
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        /**
         * 输出 q 引用的字符串：
         *
         * howdy
         */
        System.out.println(q);
        /**
         * 把 q 引用的字符串 howdy 转成大写
         */
        String qq = upcase(q);
        /**
         * 输出 qq 引用的字符串:
         *
         * HOWDY
         */
        System.out.println(qq);
        /**
         * 输出 q 引用的字符串：
         *
         * howdy
         */
        System.out.println(q);
    }
}

/*
输出：

howdy
HOWDY
howdy

 */