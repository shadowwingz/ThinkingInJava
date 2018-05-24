package chapter6.cookie2;

/**
 * Created by shadowwingz on 2018/5/24 0024.
 */
public class Cookie {
    public Cookie() {
        System.out.println("Cookie constructor");
    }

    /**
     * 被 protected 修饰的方法对于本包（chapter6.cookie2）
     * 和其子类（ChocolateChip2）可见
     *
     * 和包访问权限的区别是：
     * 父类和子类在不同包下时，
     * protected 修饰的父类的方法，对子类可见，
     * 而包访问权限修饰的方法，对子类不可见
     */
    protected void bite() {
        System.out.println("bite");
    }
}
