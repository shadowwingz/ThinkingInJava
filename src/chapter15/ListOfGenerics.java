package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-10-04 23:38
 */
public class ListOfGenerics<T> {

    /**
     * 不能直接创建泛型数组，但是可以创建泛型列表
     */
    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
