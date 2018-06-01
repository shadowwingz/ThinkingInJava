package chapter7;

/**
 * Created by shadowwingz on 2018/6/1 0001.
 *
 * private 方法都隐式的是 final 的。
 * 可以对 private 方法添加 final 修饰词，
 * 但是没有什么意义
 *
 * 当父类的某个方法是 private 修饰时，
 * 子类无法重写（Override）这个方法，
 * 所以子类的方法即使和父类方法的名字相同，
 * 也和父类方法没有关系，仅仅是名字相同而已
 */
class WithFinals {
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    /**
     * 因为 WithFinals 中的 f() 方法是 private 修饰的，
     * 所以 WithFinals 的子类无法重写 f() 方法。
     * 这里定义的 f() 方法和 WithFinals 中
     * 的 f() 方法没有关系，仅仅是名字相同而已
     */
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    /**
     * 因为 OverridingPrivate 中的 f() 方法是 private 修饰的，
     * 所以 OverridingPrivate 的子类无法重写 f() 方法。
     * 这里定义的 f() 方法和 OverridingPrivate 中
     * 的 f() 方法没有关系，仅仅是名字相同而已
     */
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        /**
         * 这里调用 OverridingPrivate2 的 f() 方法，
         * 只会调用 OverridingPrivate2 的 f() 方法，
         * 不会调用 OverridingPrivate 的 f() 方法，
         * 也不会调用 WithFinals 的 f() 方法
         *
         * op2.g() 方法同理
         */
        op2.f();
        op2.g();
        /**
         * OverridingPrivate2 向上转型为 OverridingPrivate，
         * 这时调用 f() 方法，调用的不是 OverridingPrivate2 的 f()，
         * 调用的是 OverridingPrivate 的 f() 方法，
         * 因为 OverridingPrivate2 的 f() 方法是
         * OverridingPrivate2 自己定义的，
         * 和它的父类 OverridingPrivate 的 f() 方法没有关系，
         * 所以不会根据继承关系而调用 OverridingPrivate2 的 f() 方法，
         * 又因为 OverridingPrivate 的 f() 方法是 private 修饰的，
         * 所以无法调用 OverridingPrivate 的 f() 方法
         *
         * op.g() 方法同理
         * wf.f() 方法同理
         * wf.g() 方法同理
         */
        OverridingPrivate op = op2;
//        op.f();
//        op.g();
        WithFinals wf = op2;
//        wf.f();
//        wf.g();
    }
}
