package chapter10;

/**
 * Created by shadowwingz on 2018/6/14 0014.
 */
interface A {

}

interface B {

}

/**
 * X 直接实现了 A，B 两个接口
 */
class X implements A, B {

}

/**
 * Y 只实现了 A 接口，Y 的匿名内部类实现了 B 接口
 */
class Y implements A {
    B makeB() {
        return new B() {

        };
    }
}

public class MultiInterfaces {

    static void takesA(A a) {

    }

    static void takesB(B b) {

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
