package chapter15;

import mindview.util.Generator;

/**
 * Created by shadowwingz on 2018-08-12 16:57
 * <p>
 * Fibonacci 实现了 Generator 接口，
 * 每调用一次它的 next 方法，会生成一个数字。
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        /**
         * 虽然我们在 fib 方法中返回的是 int，
         * 但是定义泛型的时候，我们用的是 Integer，
         * 这个泛型的局限性，基本类型 int 无法作为类型参数，只能用 Integer。
         */
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(gen.next());
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