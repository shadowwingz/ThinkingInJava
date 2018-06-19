package chapter12;

/**
 * Created by shadowwingz on 2018-06-19 22:41
 *
 * 为异常类 MyException 定义一个带参数的构造器
 */
class MyException extends Exception {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

public class FullConstructors {

    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            /**
             * printStackTrace 是 Throwable 的方法（Exception 继承自 Throwable），
             * printStackTrace 打印 从方法调用处直到异常抛出处 的方法调用序列，
             * 如果调用 e.printStackTrace() 不传参数，则异常信息将被输出到标准输出流。
             */
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}

/*
输出：

Throwing MyException from f()
chapter12.MyException
	at chapter12.FullConstructors.f(FullConstructors.java:20)
	at chapter12.FullConstructors.main(FullConstructors.java:30)
Throwing MyException from g()
chapter12.MyException: Originated in g()
	at chapter12.FullConstructors.g(FullConstructors.java:25)
	at chapter12.FullConstructors.main(FullConstructors.java:35)

 */