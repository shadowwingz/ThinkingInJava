package chapter10;

/**
 * Created by shadowwingz on 2018/6/13 0013.
 *
 * 从多层嵌套类中访问外部类的成员
 */
class MNA {

    private void f() {

    }

    class A {

        private void g() {

        }

        public class B {
            void h() {
                /**
                 * f() 方法和 g() 方法是 private 的，
                 * h() 方法中也可以访问到 f() 方法和 g() 方法
                 */
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
