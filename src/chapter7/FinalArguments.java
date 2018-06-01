package chapter7;

/**
 * Created by shadowwingz on 2018/6/1 0001.
 *
 * 使用 final 作为方法的形参
 * f() 方法和 g() 方法展示了：
 * 你可以读 final 修饰的参数，
 * 但是无法修改 final 修饰的参数
 */
class Gizmo {
    public void spin() {
    }
}

public class FinalArguments {
    void with(final Gizmo g) {
        /**
         * g 引用被 final 修饰，
         * 所以无法再指向新的 Gizmo 对象（new Gizmo()）
         */
//        g = new Gizmo();
    }

    void without(Gizmo g) {
        g = new Gizmo();
        g.spin();
    }

    void f(final int i) {
        /**
         * final 修饰的基本类型的变量，无法修改其值
         */
//        i++;
    }

    int g(final int i) {
        /**
         * 这里只是读取了 i 的值，并把读到的值加 1，并没有修改 i 的值
         */
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
