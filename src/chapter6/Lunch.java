package chapter6;

/**
 * Created by shadowwingz on 2018/5/24 0024.
 */
class Soup1 {
    private Soup1() {
    }

    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {
    }

    private static Soup2 ps1 = new Soup2();

    public static Soup2 access() {
        return ps1;
    }

    public void f() {
    }
}

/**
 * 每个文件只能有一个 public 类
  */
public class Lunch {
    void testPrivate() {
        /**
         * 因为 Soup1 类是包访问权限的，Lunch 和 Soup1 在同一个包下
         * 所以可以引用 => Soup1 soup
         * 因为 Soup1 类的构造器是 private 的，
         * 所以不可以创建 Soup1 对象
         */
//        Soup1 soup = new Soup1();
    }

    void testStatic() {
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }
}
