package chapter10;

/**
 * Created by shadowwingz on 2018/6/14 0014.
 */
class D {

}

abstract class E {

}

/**
 * Z 已经继承了 D，所以无法再继承 E 了，但是可以让 Z 的内部类继承 E，
 * 这里是返回了 E 的匿名内部类。这就相当于多重继承。
 */
class Z extends D {
    E makeE() {
        return new E() {

        };
    }
}

public class MultiImplementation {

    static void takesD(D d) {

    }

    static void takesE(E e) {

    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
