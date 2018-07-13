package chapter15;

import mindview.util.FiveTuple;
import mindview.util.FourTuple;
import mindview.util.ThreeTuple;
import mindview.util.TwoTuple;

/**
 * Created by shadowwingz on 2018-07-13 23:01
 */
class Amphibian {

}

class Vehicle {

}

public class TupleTest {

    /**
     * f() 方法会返回一个 TwoTuple 对象，
     * TwoTuple 对象中持有一个 String 元素和一个 Integer 元素。
     */
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        /**
         * ttsi.first 被 final 修饰，所以不能赋值
         */
//        ttsi.first = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}

/*
输出：

(hi, 47)
(chapter15.Amphibian@4554617c, hi, 47)
(chapter15.Vehicle@74a14482, chapter15.Amphibian@1540e19d, hi, 47)
(chapter15.Vehicle@677327b6, chapter15.Amphibian@14ae5a5, hi, 47, 11.1)

 */