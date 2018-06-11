package chapter10;

/**
 * Created by shadowwingz on 2018/6/11 0011.
 */
public class Parcel7b {

    class MyContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents() {
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
}
