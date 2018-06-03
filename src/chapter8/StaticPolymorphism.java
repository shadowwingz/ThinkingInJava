package chapter8;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 *
 * Polymorphism 多态性
 *
 * 静态方法不具有多态性，静态方法是与类关联，而不是与对象关联
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dyncmicGet() {
        return "Base dyncminGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dyncmicGet() {
        return "Derived dyncmicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dyncmicGet());
    }
}

/*
输出：

Base staticGet()
Derived dyncmicGet()

 */