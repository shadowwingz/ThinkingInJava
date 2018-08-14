package chapter16;

import java.util.Arrays;

/**
 * Created by shadowwingz on 2018-08-14 20:12、
 * <p>
 * int[] a = new int[1];
 * String[] a = new String[1];
 * <p>
 * 无论是使用基本类型数组还是对象数组，
 * 数组标识符 a 只是一个引用，
 * 它指向在堆中创建的一个真实对象。
 * <p>
 * 基本类型数组保存基本类型的值，
 * 对象数组保存对象的引用。
 */
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];

        /**
         * 输出：b: [null, null, null, null, null]
         *
         * 创建对象数组时，数组中的对象会自动初始化为 null，
         */
        System.out.println("b: " + Arrays.toString(b));

        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {
                c[i] = new BerylliumSphere();
            }
        }
        BerylliumSphere[] d = {
                new BerylliumSphere(),
                new BerylliumSphere(),
                new BerylliumSphere(),
        };
        a = new BerylliumSphere[]{
                new BerylliumSphere(),
                new BerylliumSphere(),
        };
        /**
         * length 只表示数组能够容纳多少元素，也就是说，
         * length 是数组的大小，而不是实际保存的元素个数。
         */
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);

        int[] e;
        int[] f = new int[5];
        /**
         * int 类型的数组，创建时，所有元素会初始化为 0。
         */
        System.out.println("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        /**
         * e 还没有初始化，不能调用它的 length 方法
         */
//        System.out.println("e.length = " + e.length);
        System.out.println("f.length = " + f.length);
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        /**
         * e 指向了 h 指向的对象，
         * 也就是说，e 和 h 指向了同一个对象。
         * 因为 h 已经初始化了，所以 e 此时也初始化了。
         * 所以此时可以调用 e.length 方法了。
         */
        e = h;
        System.out.println("e.length = " + e.length);
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length);
    }
}

/*
输出：

b: [null, null, null, null, null]
a.length = 2
b.length = 5
c.length = 4
d.length = 3
a.length = 3
f: [0, 0, 0, 0, 0]
f.length = 5
g.length = 4
h.length = 3
e.length = 3
e.length = 2

 */