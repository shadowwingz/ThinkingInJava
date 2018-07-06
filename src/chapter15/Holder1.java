package chapter15;

/**
 * Created by shadowwingz on 2018-07-06 23:13
 */
class Automobile {

}

public class Holder1 {

    /**
     * Holder1 可以持有 Automobile 及其子类的对象
     */
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}
