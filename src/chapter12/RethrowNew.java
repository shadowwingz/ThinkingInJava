package chapter12;

/**
 * Created by shadowwingz on 2018-06-20 21:59
 */
class OneException extends Exception {
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception {
    public TwoException(String message) {
        super(message);
    }
}

public class RethrowNew {

    public static void f() throws OneException {
        System.out.println("originating the exception in f()");
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                /**
                 * 在捕获 OneException 之后抛出 TwoException，
                 * 有关 OneException 异常的发生点的信息会丢失，
                 * 也就是说，OneException 经历了哪些方法调用栈，
                 * 最后在哪个方法中被抛出，我们都不知道了。
                 */
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

/*
输出：

originating the exception in f()
Caught in inner try, e.printStackTrace()
chapter12.OneException: thrown from f()
	at chapter12.RethrowNew.f(RethrowNew.java:22)
	at chapter12.RethrowNew.main(RethrowNew.java:28)
Caught in outer try, e.printStackTrace()
chapter12.TwoException: from inner try
	at chapter12.RethrowNew.main(RethrowNew.java:38)

 */