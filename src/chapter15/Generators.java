package chapter15;

import java.util.ArrayList;
import java.util.Collection;

import chapter15.coffee.Coffee;
import chapter15.coffee.CoffeeGenerator;
import mindview.util.Generator;

/**
 * Created by shadowwingz on 2018-08-12 18:47
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (int i : fnumbers) {
            System.out.print(i + ", ");
        }
    }
}

/*
输出：

Americano 0
Latte 1
Americano 2
Mocha 3
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,

 */