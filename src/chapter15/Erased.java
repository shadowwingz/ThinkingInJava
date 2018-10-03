package chapter15;

/**
 * Created by shadowwingz on 2018-10-03 23:57
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
        // 这里可以看出，在运行时我们不知道 T 的具体类型
//        if (arg instanceof T) {
//        }
        // 这里可以看出，T 无法直接被实例化
//        T var = new T();
//        T[] array = new T[SIZE];
        T[] array2 = (T[]) new Object[SIZE];
    }
}
