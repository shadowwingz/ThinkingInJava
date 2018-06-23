package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 15:37
 *
 * 当异常没有被当前的异常处理程序捕获时，
 * 异常处理机制也会在跳到更高一层的异常处理程序之前，
 * 执行 finally 子句。
 *
 * FourException 在 2 处被抛出，但是没有被捕获（catch），接
 * 着被 1 处 catch，并执行 1 处的 finally 方法。
 */
class FourException extends Exception {
}

public class AlwaysFinally {
    public static void main(String[] args) {
        /**
         * 代码执行，先输出：
         *
         * Entering first try block
         *
         * 然后输出：
         *
         * Entering second try block
         *
         * 接着在 2 处的 try 语句中调用 throw new FourException()，
         * 然后会执行 finally 语句
         * （注意：此时抛出的 FourException 还没有被捕获），输出：
         *
         * finally in 2nd try block
         *
         * 接着之前在 2 处的 try 语句中抛出的 FourException 异常，
         * 会被 1 处的 try catch 捕获，这时会进入 catch 语句，输出：
         *
         * Caught FourException in 1st try block
         *
         * 接着执行 1 处的 try catch 语句的 finally 语句，输出：
         *
         * finally in 1st try block
         */
        System.out.println("Entering first try block");
        // 1
        try {
            System.out.println("Entering second try block");
            // 2
            try {
                throw new FourException();
            } finally {
                System.out.println("finally in 2nd try block");
            }
        } catch (FourException e) {
            System.out.println("Caught FourException in 1st try block");
        } finally {
            System.out.println("finally in 1st try block");
        }
    }
}

/*
输出：

Entering first try block
Entering second try block
finally in 2nd try block
Caught FourException in 1st try block
finally in 1st try block

 */