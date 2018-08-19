package chapter15;

import java.util.ArrayList;

import mindview.util.FourTuple;

/**
 * Created by shadowwingz on 2018-08-18 16:16
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Vehicle, Amphibian, String, Integer> i : tl) {
            System.out.println(i);
        }
    }
}

/*
输出：

(chapter15.Vehicle@4554617c, chapter15.Amphibian@74a14482, hi, 47)
(chapter15.Vehicle@1540e19d, chapter15.Amphibian@677327b6, hi, 47)

 */