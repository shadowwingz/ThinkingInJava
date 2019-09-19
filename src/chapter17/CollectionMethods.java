package chapter17;

import mindview.util.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        // 将集合转换为数组
        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.min(c) = " + Collections.min(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);
    }
}
