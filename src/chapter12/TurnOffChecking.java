package chapter12;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by shadowwingz on 2018-06-24 18:50
 *
 * 把 “被检查的异常” 转换为 “不检查的异常”，
 * 即，把非 RuntimeException 的异常包装成 RuntimeException 异常。
 */
class WrapCheckedException {
    /**
     * 这里不需要声明 throws RuntimeException
     */
    void throwRuntimeException(int type) {
        /**
         * 当 type 是 0，1，2 时，抛出的异常会被 catch 语句捕获，
         * 然后被包装为 RuntimeException 异常，然后再次抛出，
         * 抛出 RuntimeException 不需要在方法中声明。
         */
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {

}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        /**
         * 调用 wce.throwRuntimeException(3)，
         * 会直接 return，不会捕获到异常，也不会有输出。
         */
        wce.throwRuntimeException(3);
        /**
         * i = 0 时，调用 wce.throwRuntimeException(0)，
         * 会抛出 FileNotFoundException 异常，然后
         * 被包装成 RuntimeException 异常再次抛出，然后被 1 处捕获，输出：
         *
         * FileNotFoundException: java.io.FileNotFoundException
         *
         * i = 1 时，调用 wce.throwRuntimeException(1)，
         * 会抛出 IOException 异常，然后
         * 被包装成 RuntimeException 异常再次抛出，然后被 2 处捕获，输出：
         *
         * IOException: java.io.IOException
         *
         * i = 2 时，调用 wce.throwRuntimeException(2)，
         * 会抛出 RuntimeException 异常，然后
         * 被包装成 RuntimeException 异常再次抛出，然后被 3 处捕获，输出：
         *
         * Throwable: java.lang.RuntimeException: Where am I?
         *
         * i = 3 时，调用 throw new SomeOtherException()，
         * 会被 4 处捕获，输出：
         *
         * SomeOtherException: chapter12.SomeOtherException
         */
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new SomeOtherException();
                }
            } catch (SomeOtherException e) {
                // 4
                System.out.println("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                /**
                 * 代码执行到这里，说明捕获到了 RuntimeException 异常，
                 * 更准确的说，是捕获到了包装后的 RuntimeException 异常，
                 * 具体是哪个异常，我们要把异常再次抛出来查看。
                 */
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    // 1
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    // 2
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    // 3
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}

/*
输出：

FileNotFoundException: java.io.FileNotFoundException
IOException: java.io.IOException
Throwable: java.lang.RuntimeException: Where am I?
SomeOtherException: chapter12.SomeOtherException

 */