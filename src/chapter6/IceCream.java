package chapter6;

/**
 * Created by shadowwingz on 2018/5/23 0023.
 */
class Sunade {
    /**
     * 构造器是 private 的，所以别的类无法通过构造器初始化它，
     * 并且别的类也无法继承它。因为继承，需要子类调用父类的构造器。
     */
    private Sunade() {
    }

    static Sunade makeASunade() {
        return new Sunade();
    }
}

public class IceCream {
    public static void main(String[] args) {
        // 因为 Sunade 类是包访问权限的，
        // 所以可以引用 => Sunade x
        // 因为 Cookie 类的构造器是 private 的，
        // 所以不可以创建 Cookie 对象
//        Sunade x = new Sunade();
        Sunade x = Sunade.makeASunade();
    }
}
