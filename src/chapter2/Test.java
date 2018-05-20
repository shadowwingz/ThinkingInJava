package chapter2;

import static chapter2.ShowProperties.test;

/**
 * Created by shadowwingz on 2018/5/13 0013.
 */
public class Test {

    {
        int x = 12;

        {
            int q = 96;
        }
    }

    private static int unsign;

    public static void main(String[] args) {
        char c = 'x';
        Character ch = new Character(c);

        Character ch2 = new Character('x');

        Character ch3 = 'x';

        char c2 = ch3;

        int unsign;

        Test[] testArray = new Test[3];
        int[] intArray = new int[3];
        boolean[] boolArray = new boolean[3];
        System.out.println(boolArray[0]);
        test();
    }
}
