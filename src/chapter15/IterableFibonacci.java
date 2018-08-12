package chapter15;

import java.util.Iterator;

/**
 * Created by shadowwingz on 2018-08-12 17:05
 * <p>
 * IterableFibonacci 在 Fibonacci 的基础上封装了一层，
 * 实现了 Iterable 接口，可以使用 for 循环来遍历。
 * 每经历一次 for 循环，都会调用一次 Iterable 接口的 next 方法，
 * 在 Iterable 的 next 方法内部，又会去调用 Fibonacci 的 next 方法。
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                /**
                 * 这里看上去是调用 IterableFibonacci 的 next 方法，
                 * 但是 IterableFibonacci 并没有 next 方法，
                 * 所以最终会去调用父类 Fibonacci 的 next 方法。
                 */
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.println(i);
        }
    }
}

/*
输出：

1
1
2
3
5
8
13
21
34
55
89
144
233
377
610
987
1597
2584

 */