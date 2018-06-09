package chapter9;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 * <p>
 * 组合接口时的名字冲突
 */
interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

/**
 * I1 和 I2 的 f 方法返回类型不同，但是不会冲突，
 * 这说明，当 implements 多个接口时，同名方法的返回类型不同，不会冲突。
 */
class C2 implements I1, I2 {
    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 1;
    }
}

/**
 * C 的 f 方法的返回值是 int 类型，没有形参，
 * I2 的 f 方法的返回值也是 int 类型，但是没有形参，
 * 因为同名方法的返回类型相同，所以这种情况下不会冲突。
 * 签名不同时，不会冲突
 * <p>
 * （方法签名由方法名称和一个参数列表（方法的参数的顺序和类型）组成。
 * 注意，方法签名不包括方法的返回类型。不包括返回值和访问修饰符。）
 */
class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 1;
    }
}

/**
 * C 和 I3 的 f 方法的签名和返回类型完全相同，所以不会冲突。
 */
class C4 extends C implements I3 {
    public int f() {
        return 1;
    }
}

/**
 * C 中的 f 方法的返回值是 int 类型，而 I1 中的 f 方法没有返回值，
 * 两个 f 方法的返回值类型不同，这种情况下会冲突，
 * 所以当 extends 一个类，又 implements 一个接口时，
 * 最好不要有同名方法，避免冲突。
 * <p>
 * 但是当 implements 多个接口时，同名方法的返回类型不同，不会冲突。
 */
//class C5 extends C implements I1 {
//
//}

public class InterfaceCollision {

}
