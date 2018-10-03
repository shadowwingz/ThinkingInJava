package chapter15;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by shadowwingz on 2018-09-29 23:08
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}

/*
输出：

[null, null, null, null, null, null, null, null, null]

 */