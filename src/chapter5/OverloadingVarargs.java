package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 *
 * f() 方法重载
 */
public class OverloadingVarargs {
    static void f(Character... args) {
        System.out.print("Character");
        for (Character c : args) {
            System.out.print(" " + c);
        }
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("Integer");
        for (Integer i : args) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    static void f(Long... args) {
        System.out.println("Long");
    }

    public static void main(String[] args) {
        f('a', 'b', 'c');
        f(1);
        f(2, 1);
        f(0);
        f(0L);
        // 当参数不为空时，编译器会使用自动包装机制来匹配重载的方法，
        // 然后调用最明确匹配的方法。
        // 但是当参数为空时（不使用参数调用 f()），
        // 编译器就不知道该调哪个方法了，因为可变参数列表是允许不传参数的，
        // 那么这种情况下上面的每个 f() 理论上都可以被调用，
        // 所以编译器就不知道该调哪个方法了
//        f();
    }
}
