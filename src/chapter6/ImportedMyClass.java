package chapter6;

import chapter6.mypackage.MyClass;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 *
 * 当要使用的类和当前类不在同一个包（package）下时，
 * 可以使用 import 导入要使用的类，这样就不需要写类的全路径类名
 */
public class ImportedMyClass {
    public static void main(String[] args) {
        MyClass m = new MyClass();
    }
}
