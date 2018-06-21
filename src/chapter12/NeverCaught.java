package chapter12;

/**
 * Created by shadowwingz on 2018-06-21 22:04
 *
 * RuntimeException （及其子类）类型的异常，
 * 可以不用 try catch，其他类型的异常就必须 try catch。
 *
 * 为什么 RuntimeException （及其子类）类型的异常可以不用 try catch？
 * 个人理解：
 * RuntimeException 类型的异常是无法处理的异常，既然无法处理，
 * 捕获了也没什么意义，那就不如直接 Crash。
 */
public class NeverCaught {

//    static void f1() throws RuntimeException {
//        throw new RuntimeException("From f()");
//    }

    static void f() {
        /**
         * 这里抛出 RuntimeException 异常，
         * 并不需要像 f1() 方法那样，在方法中声明，
         * 没有声明 RuntimeException 异常，
         * 也就意味着不需要 try catch RuntimeException 异常。
         */
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}

/*
输出：

Exception in thread "main" java.lang.RuntimeException: From f()
	at chapter12.NeverCaught.f(NeverCaught.java:27)
	at chapter12.NeverCaught.g(NeverCaught.java:31)
	at chapter12.NeverCaught.main(NeverCaught.java:35)

 */