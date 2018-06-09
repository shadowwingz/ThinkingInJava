package chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 */
public class RandomWords implements Readable {

    private static Random rand = new Random(47);

    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static final char[] vowels = "aeios".toCharArray();

    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0)
            return -1;

        cb.append(capitals[rand.nextInt(capitals.length)]);

        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }

        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}

/*
输出：

Yazersyac
Fowenscor
Goeazimom
Raesuacio
Nsoadesiw
Hageaiksx
Rsqicibsi
Nsmasetih
Ksusuozog
Waqizeyoy

 */
