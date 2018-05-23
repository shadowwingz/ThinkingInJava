package chapter6.dessert.in;

import chapter6.dessert.Cookie;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 *
 * CookieTest 在 dessert 包下的 in 包下，
 * 无法访问 Cookie 类的 bite 方法
 */
public class CookieTest {
    public static void main(String[] args) {
        Cookie cookie = new Cookie();
//        cookie.bite();
    }
}
