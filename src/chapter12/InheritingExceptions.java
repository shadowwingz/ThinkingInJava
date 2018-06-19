package chapter12;

/**
 * Created by shadowwingz on 2018-06-19 22:34
 *
 * 继承 Exception 即可创建自定义异常
 */
class SimpleException extends Exception {
}

public class InheritingExceptions {

    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            /**
             * f() 方法会抛出 SimpleException 异常
             */
            sed.f();
        } catch (SimpleException e) {
            /**
             * 抛出的 SimpleException 异常会被 catch 捕获，
             * 然后执行 catch 中的代码来处理异常，
             * 即输出：Caught it!
             */
            System.out.println("Caught it!");
        }
    }
}

/*
输出：

Throw SimpleException from f()
Caught it!

 */