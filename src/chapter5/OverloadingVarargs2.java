package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 */
public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.println("second");
    }

    static void g(float i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        // 可以编译通过
        f(1, 'a');
        // 不可以编译通过
        // 错误提示：Error:(19, 9) java: 对f的引用不明确
        // chapter5.OverloadingVarargs2 中的方法 f(float,java.lang.Character...)
        // 和 chapter5.OverloadingVarargs2 中的方法 f(java.lang.Character...) 都匹配
        // 因为 'in' 可以被传递给 float 类型的形参（ASCII码）
        // 所以上面的两个 f 方法 都可以被 f('in', 'b') 方法调用，
        // 所以编译器就不知道该调哪个方法了
//        f('in', 'b');
        g('a');
    }
}

/*
输出：

first
97.0

 */
