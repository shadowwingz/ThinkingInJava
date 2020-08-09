package chapter15;

import mindview.util.Generator;

/**
 * Created by shadowwingz on 2018-08-12 16:57
 * <p>
 * Fibonacci 实现了 Generator 接口，
 * 每调用一次它的 next 方法，会生成一个数字。
 *
 * Generator<Integer> 使用了 Integer 作为类型参数，这里不能使用 int 作为类型参数。
 * 是因为泛型擦除机制，所谓的泛型擦除机制，就是 java 源代码被编译为字节码之后，Integer 类型会被擦除为它的父类 Object，
 * Generator<Integer> 会变成 Generator<Object>。
 * 而 int 是基本类型，并没有继承自 Object，因此 int 不满足被擦除的条件，因此 int 不能用作类型参数。
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