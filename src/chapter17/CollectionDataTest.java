package chapter17;

import mindview.util.CollectionData;
import mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String> {

    String[] foundation = (
            "a b c d".split(" ")
    );

    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Government(), 2));
        set.addAll(CollectionData.list(new Government(), 2));
        System.out.println(set);
    }
}

/*

输出：

[a, b]

 */
