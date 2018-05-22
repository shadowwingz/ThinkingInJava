package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 *
 * 当两个 f 方法都添加一个非可变参数，就没问题了
 */
public class OverloadingVarargs3 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(char c, Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(1, 'a');
        f('a', 'b');
    }
}

/*
输出：

first
second

 */