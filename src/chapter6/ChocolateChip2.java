package chapter6;

import chapter6.cookie2.Cookie;

/**
 * Created by shadowwingz on 2018/5/24 0024.
 */
public class ChocolateChip2 extends Cookie {
    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }

    public void chomp() {
        bite();
    }

    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.bite();
    }
}
