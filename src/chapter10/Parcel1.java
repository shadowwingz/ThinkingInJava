package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 *
 * destination 终点
 */
public class Parcel1 {

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

    public void ship(String dest) {
        /**
         * 在 ship 方法中使用 Contents 和 Destination 这两个内部类，
         * 和使用普通的类没有区别。实际的区别只是内部类的名字是嵌套在 Parcel1 中的，
         * 在 Parcel1.class（编译后的 java 文件）中可以看到，
         * Contents 类的名字是 Parcel1.Contents，
         * Destination 类的名字是 Parcel1.Destination。
         */
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}

/*
输出：

Tasmania

 */