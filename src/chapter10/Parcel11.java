package chapter10;

/**
 * Created by shadowwingz on 2018/6/12 0012.
 *
 * 内部类声明为 static 就是嵌套类
 */
public class Parcel11 {

    private int i;

    /**
     * 静态内部类与非静态内部类之间存在一个最大的区别：
     * 非静态内部类在编译完成之后会隐含地保存着一个引用，
     * 该引用是指向创建它的外围内，但是静态内部类却没有。
     * <p>
     * 没有这个引用就意味着：
     * 1. 它的创建是不需要依赖于外围类的
     * 2. 它不能使用任何外围类的非 static 成员变量和方法
     */
    private static class ParcelContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {

        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {

        }

        static int x = 10;

        /**
         * 在静态内部类中再嵌套一个静态内部类
         */
        static class AnotherLevel {

            public static void f() {

            }

            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }
}
