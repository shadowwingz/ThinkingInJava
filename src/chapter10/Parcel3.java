package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 */
public class Parcel3 {

    class Content3 {

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

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Content3 c = p.new Content3();
        Parcel3.Destination d = p.new Destination("Tasmania");
    }
}
