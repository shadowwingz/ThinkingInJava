package chapter9;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 *
 * menace 恐吓
 * lethal 致命
 * vampire 吸血鬼
 *
 * Java 中只能 extends 一个类，
 * 但是可以 implements 多个接口，
 * 而且接口也可以 extends 接口
 */
interface Monster {
    void menace();
}

/**
 * 接口可以多重继承
 */
interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        /**
         * DangerousMonster barney = new DragonZilla();
         *
         * 左边的 DangerousMonster 是接口，右边的 DragonZilla 是实现类，
         * 引用用接口，创建对象用实现类，这样有一个好处，就是多态，
         * 说的更直白点，就是，调用 barney.menace() 方法的时候，
         * 如果实现类是 DragonZilla，那我们实际上调用的是 DragonZilla 的 menace 方法，
         * 如果实现类是别的类，那我们实现上调用的是别的类的 menace 方法，这样会很灵活。
         *
         * 如果我们这样写
         * DragonZilla barney = new DragonZilla();
         *
         * 那我们调用 barney.menace() 方法时，
         * 调用的只能是 DragonZilla 的 menace 方法，缺乏灵活性。
         */
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
