package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 */
class Parcel4 {

    private class PContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        /**
         * 这里调用 p.contents() 返回的是 Contents 接口，
         * 并且返回的接口无法向下转型为 PContents，
         * 因为在 TestParcel 中无法访问到 private 修饰的 PContents。
         * 所以我们可以调用接口中的方法，但是不知道方法是怎么实现的。
         * 这就体现了一种封装。
         */
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        /**
         * PContents 是 private 的，在 TestParcel 中无法访问
         */
//        Parcel4.PContents = p.new PContents();
    }
}
