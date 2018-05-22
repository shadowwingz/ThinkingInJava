package chapter5;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
public class NewVarArgs {
    // 可变参数列表，也就是三个点（...）
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 直接传三个参数，不需要用数组包起来
        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A());
        // 创建一个 Integer 数组，然后向上转型为 Object 数组
        // 这里也可以看出，printArray 虽然接收的是可变参数列表，
        // 但是我们传入数组，它也可以接收
        printArray((Object[]) new Integer[]{1, 2, 3, 4});
        // 空数组，这里也可以看出，将 0个参数传递给可变参数列表是可行的
        printArray();
        // 因为可变参数的类型是 Object，所以参数可以随便传
        printArray("1", 2, new Float(3), new A());
    }
}

/*
输出：

47 3.14 11.11
47 3.14 11.11
one two three
chapter5.A@4554617c chapter5.A@74a14482 chapter5.A@1540e19d
1 2 3 4

1 2 3.0 chapter5.A@677327b6

 */