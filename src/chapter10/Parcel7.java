package chapter10;

/**
 * Created by shadowwingz on 2018/6/11 0011.
 */
public class Parcel7 {

    public Contents contents() {
        /**
         * 就要返回类的对象之前才定义类
         */
        return new Contents() {

            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
