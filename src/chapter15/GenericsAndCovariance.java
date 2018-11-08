package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-11-08 22:18
 *
 * P391
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null);
        Fruit f = flist.get(0);
    }
}
