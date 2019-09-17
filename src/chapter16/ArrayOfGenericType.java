package chapter16;

public class ArrayOfGenericType<T> {

    T[] array;

    public ArrayOfGenericType(int size) {
        // 不能直接初始化泛型
//        array = new T[size];
        array = (T[]) new Object[size];
    }
}
