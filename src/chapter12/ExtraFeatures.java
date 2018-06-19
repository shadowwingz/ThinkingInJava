package chapter12;

/**
 * Created by shadowwingz on 2018-06-19 23:08
 *
 * 自定义异常，加入额外的构造器和成员
 */
class MyException2 extends Exception {

    private int x;

    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String message, int x) {
        super(message);
        this.x = x;
    }

    public int val() {
        return x;
    }

    /**
     * 对于异常类来说，getMessage() 方法类似于 toString() 方法
     */
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {

    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}

/*
输出：

Throwing MyException2 from f()
chapter12.MyException2: Detail Message: 0 null
	at chapter12.ExtraFeatures.f(ExtraFeatures.java:35)
	at chapter12.ExtraFeatures.main(ExtraFeatures.java:50)
Throwing MyException2 from g()
chapter12.MyException2: Detail Message: 0 Originated in g()
	at chapter12.ExtraFeatures.g(ExtraFeatures.java:40)
	at chapter12.ExtraFeatures.main(ExtraFeatures.java:56)
Throwing MyException2 from h()
chapter12.MyException2: Detail Message: 47 Originated in h()
	at chapter12.ExtraFeatures.h(ExtraFeatures.java:45)
	at chapter12.ExtraFeatures.main(ExtraFeatures.java:62)
e.val() = 47

 */
