package chapter10;

/**
 * Created by shadowwingz on 2018/6/11 0011.
 * <p>
 * 在方法的作用域内创建一个完整的类，这被称作局部内部类。
 */
public class Parcel5 {

    public Destination destination(String s) {

        /**
         * 局部内部类的对象需在内部类编译后再创建，
         * 也就是说，局内内部类要先定义，再创建。
         */
//        PDestination p = new PDestination(s);

        /**
         * 局部内部类放在外部类的方法体内，前面不能有修饰符，
         * 因为修饰符是用来修饰类的成员，不是用来修饰方法的成员
         */
        class PDestination implements Destination {

            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }

            public void print() {
                System.out.println(label);
            }
        }
        /**
         * 向上转型为 Destination 接口，
         * 在这里可以创建 PDestination。
         *
         * 局部内部类对于外界是隐藏的，也就是说，
         * 在其它类中，是无法访问到 PDestination 类的。
         * 因此需要在内部类里面完成对象的定义和引用。
         * 所以我们要在 destination() 方法的内部创建好 PDestination 对象，
         * 并返回它的引用，这样，别的类才可以通过 destination() 方法
         * 获取到 PDestination 对象的引用。
         * 别的类是无法直接创建 PDestination 对象，
         * 只能通过这种方法获取到 PDestination 对象的引用
         */
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        /**
         * 这里只能获取到 Destination 的引用，
         * 无法获取到 PDestination 的引用，
         * 因为 PDestination 是定义在 destination 方法中的，
         * PDestination 类是 destination() 方法的一部分，
         * 而不是 Parcel5 的一部分。
         * 所以在 Parcel5 中无法访问到 PDestination。
         *
         * 当方法运行完，局部内部类的对象也就释放了。
         */
        Destination d = p.destination("Tasmania");
    }
}
