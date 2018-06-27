package chapter14;

/**
 * Created by shadowwingz on 2018-06-27 22:18
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        /**
         * ? extends Number
         *
         * 表示 Number 类及其子类
         */
        Class<? extends Number> bounded = int.class;
        /**
         * 只要是 Number 类的子类，都可以赋值给 bounded
         */
        bounded = double.class;
        bounded = Number.class;
    }
}
