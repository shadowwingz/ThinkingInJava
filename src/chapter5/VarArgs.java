package chapter5;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
class A {
}

public class VarArgs {
    // 注意，这里的形参是一个数组
    static void printArray(Object[] args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 调用 printArray 方法，想传多个参数，必须用 new Object[]{} 包起来，才能传进去
        // 如果形参是可变参数列表，也就是三个点（...），这时直接传参数就可以了，
        // 不过本质上还是基于数组的实现
        printArray(new Object[]{
                new Integer(47), new Float(3.14), new Double(11.11)
        });
        printArray(new Object[]{
                "one", "two", "three"
        });
        // 没有重写 toString() 方法时，打印对象，打印出来的是类的名字和对象的地址
        printArray(new Object[]{
                new A(), new A(), new A()
        });
    }
}

/*
输出

47 3.14 11.11
one two three
chapter5.A@4554617c chapter5.A@74a14482 chapter5.A@1540e19d

 */
