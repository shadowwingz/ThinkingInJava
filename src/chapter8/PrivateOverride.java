package chapter8;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 * <p>
 * Derived 派生，导出
 * <p>
 * 我们预想的输出是 public f()，但实际输出的是 private f()
 * <p>
 * 因为基类 PrivateOverride 中的 f() 是 private 修饰的，
 * 而 private 方法又默认是 final 的，所以基类的 f() 方法无法被重写，
 * 此时子类 Derived 的 f() 方法和基类的 f() 方法是没有关系的，
 * 相当于子类自己定义了一个 f() 方法，当我们调用 po.f() 时，
 * 编译器会去寻找 PrivateOverride 类有没有 f() 方法，
 * 然后，编译器会发现 PrivateOverride 中有 f() 方法，
 * 然后，编译器会继续找 PrivateOverride 的子类，
 * 看子类有没有重写 f() 方法，因为子类无法重写 f() 方法，
 * 所以编译器找不到重写的 f() 方法，这时，
 * 编译器只好去调用基类的 f() 方法，所以会输出 private f()
 *
 * 这也给我们一个教训，在子类中，对于父类中的 private 方法，
 * 最好采用不同的名字，否则容易造成混淆。
 */
public class PrivateOverride {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}

/*
输出：

private f()

 */
