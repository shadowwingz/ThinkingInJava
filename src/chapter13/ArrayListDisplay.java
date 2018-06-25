package chapter13;

import java.util.ArrayList;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;

/**
 * Created by shadowwingz on 2018-06-25 21:29
 */
public class ArrayListDisplay {
    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<>();
        for (Coffee c : new CoffeeGenerator(10)) {
            coffees.add(c);
        }
        /**
         * ArrayList 的 toString 方法会遍历 ArrayList 中
         * 的所有对象，调用每个元素的 toString 方法。
         */
        System.out.println(coffees);
    }
}

/*
输出：

[Americano 0, Latte 1, Americano 2, Mocha 3, Mocha 4, Breve 5,
Americano 6, Latte 7, Cappuccino 8, Cappuccino 9]

 */
