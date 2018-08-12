package chapter15.coffee;

import java.util.Iterator;
import java.util.Random;

import mindview.util.Generator;

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
        for (int i = 0; i < 5; i++) {
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
