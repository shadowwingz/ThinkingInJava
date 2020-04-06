package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-10-03 23:40
 */
public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        /**
         * 这里创建了一个泛型 T 的 ArrayList，这个 ArrayList 的泛型会被擦除，
         * 所以编译器不知道 T 的类型，但是编译器依然可以保证
         * 这个 ArrayList 添加的是 T 类型的数据。也就是说，
         * 这个 ArrayList，添加 T 类型的数据不会报错，
         * 添加别的类型的数据就会报错，虽然编译器也不知道 T 类型到底是什么类型。
         *
         * 在本例中，虽然我们指定的泛型 T 是 String 类型，但是对编译器来说，它并不知道 T 是 String，
         * 它只知道 ArrayList 可以添加 T 类型的数据，所以 result.add(t) 不会报错。
         * 但是如果让 ArrayList 添加任意一种其他类型，比如 Integer，或者 String，就会报错。
         * 换句话说，ArrayList 只认 T，别的都不认。
         */
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
            // result.add(1) 报错
//            result.add("1"); 报错
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }
}

/*
输出：

[Hello, Hello, Hello, Hello]

 */