package chapter6.dessert;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 *
 * CookieTest 和 Cookie 在同一个包下，
 * 可以访问 Cookie 类的 bite 方法
 */
public class CookieTest {
    public static void main(String[] args) {
        Cookie cookie = new Cookie();
        cookie.bite();
    }
}
