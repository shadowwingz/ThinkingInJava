package chapter15;

import java.util.Iterator;

/**
 * Created by shadowwingz on 2018-08-12 17:05
 * <p>
 * 如果要使 Fibonacci 实现 Iterable，并不一定需要修改 Fibonacci 源文件的代码，比如让 Fibonacci 实现 Iterable 接口，
 * 但是我们有时候不一定有权限修改源文件，这种情况下我们就得想别的方法来实现了。
 *
 * 我们可以创建一个适配器来实现所需的接口。所谓的适配器，就是新建一个类 IterableFibonacci，来继承 Fibonacci，
 * 并让 IterableFibonacci 来实现 Iterable 接口，然后在 Iterable 的方法中，我们调用 Fibonacci 相应的方法。
 * 总之，我们对于 Fibonacci 的方法调用都是通过 IterableFibonacci 来间接调用的。
 *
 * IterableFibonacci 在 Fibonacci 的基础上封装了一层，
 * 实现了 Iterable 接口，可以使用 for 循环来遍历。
 * 每经历一次 for 循环，都会调用一次 Iterable 接口的 next 方法，
 * 在 Iterable 的 next 方法内部，又会去调用 Fibonacci 的 next 方法。
 *
 * IterableFibonacci 虽然继承自 Fibonacci，但其实并没有比 Fibonacci
 * 多做什么，它只是多了一个控制迭代次数的功能。
 * 但是这种思想很重要，也就是适配器的设计模式，我们不需要修改 Fibonacci 的源码，
 * 就可以在 Fibonacci 的基础上增加功能。
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