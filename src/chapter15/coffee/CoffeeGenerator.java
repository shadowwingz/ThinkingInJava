package chapter15.coffee;

import mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by shadowwingz on 2018-07-23 21:50
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {
            Latte.class,
            Mocha.class,
            Cappuccino.class,
            Americano.class,
            Breve.class
    };

    private static Random rand = new Random(47);

    public CoffeeGenerator() {

    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        /**
         * 传统的用法是先创建出 iterator，再调用 iterator.next 方法
         * 来获取 Coffee 对象，但是这里会发现打印不出对象，
         * 只有直接调用 gen.next 方法才能打印对象。
         * 原因是 gen.next 方法是 Generator 接口中的方法，
         * 调用此 next 方法会直接返回一个 Coffee 对象，并且
         * 调用此 next 方法和 Iterable 接口没有关系。
         *
         * 而调用 iterator.next 方法时，是调用的 Iterable 接口的方法，
         * 在 Iterable 接口的 hasNext 方法中，对 count 进行了判断，
         * 只有 count 大于 0，才返回 true。
         * 而 count 的值决定于创建 CoffeeGenerator 对象时，传入的值。
         * 如果没有传值，count 默认就是 0。
         * 这种情况下 hasNext 会返回 false。所以也就不会执行到 next 方法。
         * 因此不会打印出 Coffee 对象的值。
         */
        // 不会打印
//        Iterator<Coffee> iterator = gen.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        for (int i = 0; i < 5; i++) {
            // 使用 gen.next 是通过 Generator 接口的 next 方法获取到的 Coffee 对象
            System.out.println(gen.next());
        }
        /**
         * new CoffeeGenerator() 传入的是 5，
         * 所以 CoffeeIterator 中的 count 也是 5，
         * 当 foreach 每执行一次时，都会调用 hasNext 方法判断，
         * 如果 hasNext 为 true，就执行下一次遍历，
         * 如果为 false，就停止遍历。
         * 每执行一次遍历，count 都会减一，
         * 所以 for 循环只能执行 5 次。
         */
        for (Coffee c : new CoffeeGenerator(5)) {
            // 使用 for 循环是通过 Iterable 接口的 next 方法获取到的 Coffee 对象
            System.out.println(c);
        }
    }
}

/*
输出：

Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9

 */
