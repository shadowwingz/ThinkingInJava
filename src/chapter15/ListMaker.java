package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-10-03 23:32
 */
public class ListMaker<T> {
    List<T> create() {
        /**
         * 虽然我们在这里创建了泛型 T 的 ArrayList，但是在运行时，
         * 这个 ArrayList 的泛型 T 会被擦除，也就是说，在运行时，
         * 这个 ArrayList 就是个普通的 List，和 T 没有关系。
         */
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }
}
