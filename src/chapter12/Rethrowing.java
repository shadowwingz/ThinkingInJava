package chapter12;

/**
 * Created by shadowwingz on 2018-06-20 21:24
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g().e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h().e.printStackTrace()");
            e.printStackTrace(System.out);
            /**
             * 调用 fillInStackTrace 方法会更新异常信息，
             * 调用 fillInStackTrace 方法的那一行会成为异常的新发生地
             */
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

/*
输出：

originating the exception in f()
Inside g().e.printStackTrace()
java.lang.Exception: thrown from f()
	at chapter12.Rethrowing.f(Rethrowing.java:10)
	at chapter12.Rethrowing.g(Rethrowing.java:15)
	at chapter12.Rethrowing.main(Rethrowing.java:39)
main: printStackTrace()
java.lang.Exception: thrown from f()
	at chapter12.Rethrowing.f(Rethrowing.java:10)
	at chapter12.Rethrowing.g(Rethrowing.java:15)
	at chapter12.Rethrowing.main(Rethrowing.java:39)
originating the exception in f()
Inside h().e.printStackTrace()
java.lang.Exception: thrown from f()
	at chapter12.Rethrowing.f(Rethrowing.java:10)
	at chapter12.Rethrowing.h(Rethrowing.java:25)
	at chapter12.Rethrowing.main(Rethrowing.java:46)
main: printStackTrace()
java.lang.Exception: thrown from f()
	at chapter12.Rethrowing.h(Rethrowing.java:33)
	at chapter12.Rethrowing.main(Rethrowing.java:46)

 */