package chapter10;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 */
class Egg2 {

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }

        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    public Egg2() {
        System.out.println("New Egg2()");
    }

    public void insertYolk(Yolk yy) {
        y = yy;
    }

    public void g() {
        y.f();
    }
}

public class BigEgg2 extends Egg2 {

    public class Yolk extends Egg2.Yolk {

        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }

        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        /**
         * 调用 new BigEgg2()，会初始化 BigEgg2，初始化 BigEgg2 之前，会初始化 Egg2。
         * 先初始化 Egg2 的成员变量，即执行 private Yolk y = new Yolk()，
         * 这时会调用 Egg2 的内部类 Yolk 的构造方法，于是输出：
         *
         * Egg2.Yolk()
         *
         * 接着调用 Egg2 的构造方法，于是输出：
         *
         * New Egg2()
         *
         * 接着初始化 BigEgg2，调用 BigEgg2 的构造方法，
         * 在 BigEgg2 的构造方法中，又调用 insertYolk(new Yolk())，
         * 所以先调用 new Yolk()，这时 new 的是 BigEgg2 的内部类 Yolk，
         * 所以会调用 BigEgg2 的内部类 Yolk 的构造方法，
         * 在调用 BigEgg2 的内部类 Yolk 的构造方法，
         * 会先调用 BigEgg2 的内部类 Yolk 的父类的构造方法，
         * 即 Egg2 的内部类 Yolk 的构造方法，于是输出：
         *
         * Egg2.Yolk()
         *
         * 接着调用 BigEgg2 的内部类 Yolk 的构造方法，于是输出：
         *
         * BigEgg2.Yolk()
         *
         * 接着调用 insertYolk，这时会把 BigEgg2 的内部类 Yolk 对象
         * 向上转型为 Egg2 的内部类 Yolk，
         *
         * 接着调用 e2.g()，在内部会调用 y.f()，
         * 这里的 y 就是刚刚传入的 BigEgg2 的内部类 Yolk 对象，
         * 调用 y.f() 会调用 BigEgg2 的内部类 Yolk 对象的 f() 方法，
         * 于是输出：
         *
         * BigEgg2.Yolk.f()
         */
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}

/*
输出：

Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()

 */