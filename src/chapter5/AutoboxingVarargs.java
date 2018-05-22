package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 *
 * 可变参数类型虽然不会帮我们自动装箱，
 * 但是它可以和自动包装机制和谐共处
 */
public class AutoboxingVarargs {
    public static void f(Integer... args) {
        for (Integer i : args) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(new Integer(1), new Integer(2));
        f(4, 5, 6, 7, 8, 9);
        f(10, new Integer(11), 12);
    }
}

/*
输出：

1 2
4 5 6 7 8 9
10 11 12

 */