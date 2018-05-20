package chapter3;

/**
 * Created by shadowwingz on 2018/5/16 0016.
 */
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long) i;
        lng = i;
        long lng2 = (long) 200;
        i = (int) lng2;
    }
}
