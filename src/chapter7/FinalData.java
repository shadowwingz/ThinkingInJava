package chapter7;

import java.util.Random;

/**
 * Created by shadowwingz on 2018/5/30 0030.
 *
 * 总结：
 * final 修饰的基本类型数据，不能修改其数值
 * final 修饰的引用，不能修改引用，但能修改引用指向的对象的值
 * final 修饰的数据，不一定在编译时（编译为 class 文件）
 * 就可以知道它的值（例如 Random），有可能在运行时
 * （class 文件被虚拟机加载）才能知道它的值
 */
class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    /**
     * valueOne 和 VALUE_TWO 都是带有编译时数值的 final 基本类型，
     * 所以它们二者均可以用作编译期常量
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    /**
     * 定义为 public，则可以被用于包之外；
     * 定义为 static，则强调只有一份；
     * 定义为 final，则说明它是一个常量
     */
    public static final int VALUE_THREE = 39;
    /**
     * i4 和 INT_5 说明了 我们不能因为某数据
     * 是 final 就认为在编译时可以知道它的值，
     * 它的数值是随机生成的
     *
     * i4 的值是在 java 代码编译为 class 文件时确定的，
     * INT_5 的值是在 java 代码编译为 class 文件，class 文件被虚拟机加载时确定的
     */
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        /**
         * final 修饰的基本类型变量的值无法被修改
         */
//        fd1.valueOne++;
        /**
         * v2 虽然被 final 修饰，但是 v2 是对象引用，
         * 对于对象引用，final 保证引用的值不会被修改
         * （引用被修改的情况是 v2 = ，也就是后面是个赋值符号）
         * 但是不保证引用指向的对象的值不会被修改
         * （v2.i++，修改是的 v2 引用指向的对象的 i 字段）
         */
        fd1.v2.i++;
        /**
         * v1 没有被 final 修饰，所以 v1 引用的值可以被修改
         */
        fd1.v1 = new Value(9);
        for (int i = 0; i < fd1.a.length; i++) {
            /**
             * fd1.a 是个引用，它指向的是一个数组对象（数组是一个对象），
             * final 修饰 a，导致 a 引用无法被修改，
             * 也就是说 a 引用无法指向别的对象了
             * 但是 a 引用指向对象的值可以被修改
             */
            fd1.a[i]++;
            // a 引用无法被修改
//            fd1.a = new int[1];
            // final 修饰的引用无法被修改
//            fd1.v2 = new Value(0);
        }
        // final 修饰的引用无法被修改
//        FinalData.VAL_3 = new Value(1);
        // final 修饰的引用无法被修改（数组也是对象）
//        fd1.a = new int[3];
        System.out.println(fd1);
        FinalData fd2 = new FinalData("fd2");
        /**
         * fd1 和 fd2 的 i4 和 INT_5 都是 Random 生成的，
         * 但是 i4 是非 static 的，所以每次创建 FinalData 对象都会重新创建，
         * INT_5 是 static 的，只会创建一次，
         * 所以 fd1 和 fd2 的 i4 不同，INT_5 相同
         */
        System.out.println(fd1);
        System.out.println(fd2);
    }
}

/*
输出：

fd1: i4 = 15, INT_5 = 18
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18

 */