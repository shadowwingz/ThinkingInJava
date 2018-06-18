package chapter11;

import java.util.Iterator;

/**
 * Created by shadowwingz on 2018-06-18 22:51
 */
public class IterableClass implements Iterable<String> {

    protected String[] words = ("And that is how we " +
            "know the Earth to be banana-shaped.").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
    }
}

/*
输出：

And that is how we know the Earth to be banana-shaped.

 */