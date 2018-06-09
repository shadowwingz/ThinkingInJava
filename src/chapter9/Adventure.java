package chapter9;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 */
interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {

    }
}

/**
 * 如果要同时继承类和实现接口，要先继承类，再实现接口
 *
 * Hero 虽然实现了 CanFight 接口，但是并没有实现 fight 方法，
 * 编译器也没有报错，因为 Hero 继承的类 ActionCharacter 中
 * 已经定义了 fight 方法，虽然 ActionCharacter 并没有实现 CanFight 接口，
 * 这也说明，当一个类 implements 了一个接口时，假如接口中有一个 a 方法，
 * 这时类应该去实现 a 方法，但是这个类在 implements 接口之前就已经有一个 a 方法，
 * 那么此时类就不需要再去定义一个 a 方法了。
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }
}

public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        /**
         * 创建 Hero 对象时，必须保证 Hero 实现的接口中的方法都实现了，
         * 才能创建 Hero 对象
         */
        Hero h = new Hero();
        /**
         * 这里可以看出继承和接口的灵活性，
         * Hero 对象可以向上转型为 ActionCharacter 类型，
         * 也可以向上转型为 CanFight，CanSwim，CanFly 接口类型
         */
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
