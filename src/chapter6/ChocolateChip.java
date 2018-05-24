package chapter6;

import chapter6.dessert.Cookie;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 */
// ChocolateChip 巧克力片
public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        /**
         * 因为 bite 方法是包访问权限，而 Cookie 和 ChocolateChip 不在同一个包下，
         * 所以 ChocolateChip 无法调用 Cookie 的 bite 方法
         */
//        bite();
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
