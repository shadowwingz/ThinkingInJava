package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-08-12 18:18
 * <p>
 * 泛型方法可以和可变参数列表一起使用
 */
public class GenericVarargs {
    /**
     * T...
     *
     * T 是泛型
     * ... 是可变参数列表
     */
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFG".split(""));
        System.out.println(ls);
    }
}

/*
输出：

[A]
[A, B, C]
[A, B, C, D, E, F, G]

 */