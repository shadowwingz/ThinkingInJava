package chapter9;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 */
class A {
    /**
     * 接口可以嵌套在类里
     */
    interface B {
        void f();
    }

    public class BImp implements B {
        @Override
        public void f() {

        }
    }

    private class BImp2 implements B {
        @Override
        public void f() {

        }
    }

    public interface C {
        void f();
    }

    class CImp implements C {
        @Override
        public void f() {

        }
    }

    private class CImp2 implements C {
        @Override
        public void f() {

        }
    }

    /**
     * 接口可以是 private 的
     */
    private interface D {
        void f();
    }

    private class DImp implements D {
        @Override
        public void f() {

        }
    }

    public class DImp2 implements D {
        @Override
        public void f() {

        }
    }

    public D getD() {
        return new DImp2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

/**
 * 接口之间也可以嵌套
 */
interface E {
    interface G {
        void f();
    }

    public interface H {
        void f();
    }

    void g();

    /**
     * 接口内部嵌套的接口不能为 private
     */
//    private interface I {}
}

public class NestingInterfaces {

    public class BImp implements A.B {
        @Override
        public void f() {

        }
    }

    class CImp implements A.C {
        @Override
        public void f() {

        }
    }

    /**
     * A.D 接口是 private 的，在 NestingInterfaces 中
     * 无法访问到 A.D 接口，所以 DImp 无法 implements A.D 接口
     */
//    class DImp implements A.D {
//    }

    class EImp implements E {
        @Override
        public void g() {

        }
    }

    class EGImp implements E.G {
        @Override
        public void f() {

        }
    }

    class EImp2 implements E {
        @Override
        public void g() {

        }

        class EG implements E.G {
            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        /**
         * A.D 接口是 private 的，所以无法访问
         */
//        A.D ad = a.getD();
        /**
         * a.getD() 返回的是 A.D 接口，A.D 接口需要向下转型为 A.DImp2 才能编译通过
         */
//        A.DImp2 di2 = a.getD();
//        a.getD().f();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
