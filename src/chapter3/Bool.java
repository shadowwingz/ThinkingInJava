package chapter3;

import java.util.Random;

/**
 * Created by shadowwingz on 2018/5/15 0015.
 */
public class Bool {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.println("i && j is " + (true && false));
    }
}
