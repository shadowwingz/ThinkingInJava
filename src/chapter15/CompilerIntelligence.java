package chapter15;

import java.util.Arrays;
import java.util.List;


/**
 * Created by shadowwingz on 2018-11-08 22:54
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        flist.contains(new Apple());
        flist.indexOf(new Apple());
//        flist.add(new Apple());
    }
}
