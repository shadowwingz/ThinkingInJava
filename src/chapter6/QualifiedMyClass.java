package chapter6;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 *
 * 当要使用的类和当前类不在同一个包（package）下时，
 * 需要写类的全路径类名
 */
public class QualifiedMyClass {
    public static void main(String[] args) {
        // 使用完整的类名
        chapter6.mypackage.MyClass m = new chapter6.mypackage.MyClass();
    }
}
