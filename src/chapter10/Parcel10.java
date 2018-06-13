package chapter10;

/**
 * Created by shadowwingz on 2018/6/12 0012.
 *
 * 在匿名类内部定义字段并初始化
 */
public class Parcel10 {

    /**
     * 在 Java 1.8 之前 dest 和 price 需要加 final 修饰。
     * Java 1.8 开始，如果没有对 price 进行修改，就不需要加 final。
     */
    public Destination destination(String dest, float price) {
        return new Destination() {

            private int cost;

            /**
             * 非静态内部类不能有 static 成员（字段和方法）
             *
             * 因为非静态内部类必须依赖外部类的实例创建实例，在实例化的时候才分配内存，但是
             * 静态的成员需要在编译时就分配内存，所以非静态内部类不能有 static 成员。
             */
//            static int i;

//            static void f() {
//
//            }

            /**
             * 对于匿名类而言，实例初始化的实际效果就是构造器
             */
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}

/*
输出：

Over budget!

 */
