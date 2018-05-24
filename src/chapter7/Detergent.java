package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 *
 * 当使用继承时，会自动得到基类中所有的域和方法，
 * 虽然 private 修饰的父类的方法子类无法调用，但是子类拥有
 */
class Cleanser {

    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser {

    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}

/*
输出：

Cleanser dilute() apply() scrub()

 */
