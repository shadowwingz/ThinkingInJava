package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 */
public class Parcel2 {

    class Contents {

        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {

        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    Contents mContents = new Contents();

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    // 1、外部类的非静态方法之外(成员变量)
    Contents c2 = new Contents();

    // 2、外部类的非静态方法之外(静态变量)
    static Contents c3 = new Parcel2().new Contents();

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        /**
         * 这样写，层次很明显，可以一眼看出 Contents 是 Parcel2 的内部类
         */
        Parcel2.Contents c4 = new Parcel2().new Contents();
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
    }
}

/*
输出：

Tasmania

 */