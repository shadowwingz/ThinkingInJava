package chapter14;

import java.util.Random;

/**
 * Created by shadowwingz on 2018-06-26 22:36
 */
class Initable {

    static final int staticFinal = 47;

    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    static int staticNotFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {

    static int staticNotFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 调用 Initable.class 并不会初始化 Initable
         */
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        /**
         * 调用 Initable.staticFinal 并没有初始化 Initable
         * （Initable 的初始化标志是打印 Initializing Initable），
         * 调用 Initable.staticFinal2 才初始化 Initable，
         * 也就是说，当对静态方法（构造方法隐式的是静态的）或者
         * 非常数（staticFinal 是常数）静态域进行首次引用，才会初始化类。
         *
         * 如果一个 static final 值是 编译期常量（具体的数值，比如 47），
         * 就像 Initable.staticFinal 一样，那么这个值不需要对 Initable 类
         * 进行初始化就可以被读取。
         *
         * 因为如果一个 static 域不是 final 的，那么在访问它时，
         * 总是要先进行链接（为域分配存储空间）和初始化（初始化存储空间）。
         */
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNotFinal);
        Class initable3 = Class.forName("chapter14.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNotFinal);
    }
}

/*
输出：

After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74

 */