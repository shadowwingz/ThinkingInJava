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
         * 在本例中，泛型 T 是 String，但编译器并不知道 T 是 String，
         * 但是 ArrayList 添加 String 类型的数据，编译器不会报错，
         * 添加 int 类型的数据，编译器就会报错。
         */
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
            // result.add(1) 报错
//            result.add(1);
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