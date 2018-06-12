package chapter10;

/**
 * Created by shadowwingz on 2018/6/12 0012.
 *
 * 在匿名类中没有命名构造器，但通过实例初始化，
 * 就能够达到为匿名内部类创建一个构造器的效果。
 */
abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {

            /**
             * 实例初始化
             */
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In annoymous f()");
            }
        };
    }

    public static void main(String[] args) {
        /**
         * 调用 getBase 方法，会调用 new Base，接着会调用 Base 的构造器，
         * 接着会输出 Base constructor, i = 47，
         * 接着会初始化非静态代码块，输出 Inside instance initializer。
         */
        Base base = getBase(47);
        base.f();
    }
}

/*
输出：

Base constructor, i = 47
Inside instance initializer
In annoymous f()

 */
