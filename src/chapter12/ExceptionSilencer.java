package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 18:01
 *
 * 在 finally 语句中使用 return 会丢失异常。
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            /**
             * 如果屏蔽掉 return，会打印
             * Exception in thread "main" java.lang.RuntimeException
             *      at chapter12.ExceptionSilencer.main
             *
             * 如果不屏蔽，什么都不会打印
             */
            return;
        }
    }
}
