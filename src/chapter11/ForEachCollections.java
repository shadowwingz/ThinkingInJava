package chapter11;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by shadowwingz on 2018-06-18 22:48
 *
 * foreach 语法可以用于任何 Collection 对象。
 */
public class ForEachCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
    }
}

/*
输出：

'Take' 'the' 'long' 'way' 'home'

 */