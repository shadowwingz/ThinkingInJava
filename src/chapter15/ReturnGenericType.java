package chapter15;

/**
 * Created by shadowwingz on 2018-08-19 17:58
 * <p>
 * 当使用 ReturnGenericType 时，T 会被擦除为 HasF 或 HasF 的子类，
 * 这个时候，T 的类型是不确定的，只能知道它的范围，即 HasF 或 HasF 的子类。
 * 但是，当我们调用 getObj 方法时，会返回具体类型。
 */
public class ReturnGenericType<T extends HasF> {

    private T obj;

    public ReturnGenericType(T x) {
        obj = x;
    }

    public T getObj() {
        return obj;
    }

    public static void main(String[] args) {
        ReturnGenericType type = new ReturnGenericType(new A());
        System.out.println(type.getObj().getClass().getSimpleName());
    }

    static class A extends HasF {

    }
}

/*
输出：

A

 */