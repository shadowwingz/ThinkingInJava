package chapter15;

/**
 * Created by shadowwingz on 2018-08-19 17:55
 */
public class Manipulator3 {

    private HasF obj;

    public Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
