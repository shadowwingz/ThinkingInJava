package chapter15;

/**
 * Created by shadowwingz on 2018-08-19 17:58
 */
public class ReturnGenericType<T extends HasF> {

    private T obj;

    public ReturnGenericType(T x) {
        obj = x;
    }

    public T getObj() {
        return obj;
    }
}
