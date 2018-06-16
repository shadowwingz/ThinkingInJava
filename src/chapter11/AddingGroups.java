package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);

        /**
         * Arrays.asList 方法输出的对象虽然是 List，
         * 但是其底层表示的是数组，因此不能调节尺寸，
         * 也就是说，不能再调用 add 方法添加元素。
         * 否则会报 UnsupportedOperationException 异常。
         */
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        list.add(21);
    }
}

/*
输出：

Exception in thread "main" java.lang.UnsupportedOperationException

 */
