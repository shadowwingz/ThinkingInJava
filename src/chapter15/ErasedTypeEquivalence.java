package chapter15;

import java.util.ArrayList;

/**
 * Created by shadowwingz on 2018-08-19 17:09
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}

/*
输出：

true

 */