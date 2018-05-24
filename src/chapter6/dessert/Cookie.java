package chapter6.dessert;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 */
// 类是 public 的
public class Cookie {
    // 构造器是 public 的
    public Cookie() {
        System.out.println("Cookie constructor");
    }

    /**
     * bite 方法是包访问权限，
     * 只有和 Cookie 类在同一个包下的类才能访问这个方法
     */
    void bite() {
        System.out.println("bite");
    }
}
