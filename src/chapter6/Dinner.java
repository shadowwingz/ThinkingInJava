package chapter6;

import chapter6.dessert.Cookie;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 */
public class Dinner {
    public static void main(String[] args) {
        // 因为 Cookie 类是 public 的，
        // 所以可以引用 => Cookie x
        // 因为 Cookie 类的构造器是 public 的，
        // 所以可以创建 Cookie 对象 => new Cookie()
        // 因为 Cookie 类的 bite 方法是包访问权限，
        // 而 Cookie 类和 Dinner 类又不在同一个包（package）下，
        // 所以无法调用 x.bite()
        Cookie x = new Cookie();
//        x.bite();
    }
}
