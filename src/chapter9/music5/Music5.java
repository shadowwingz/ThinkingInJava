package chapter9.music5;

import chapter8.music.Note;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 *
 * 接口中定义的变量默认是 static 和 final 的，
 * 接口中定义的方法默认是 public 的
 */
interface Instrument {

    /**
     * 编译时常量，接口中定义的变量默认是 static 和 final 的
     */
    int VALUE = 5;

    /**
     * play 方法虽然没有用 public 修饰，但是默认是 public 的
     */
    void play(Note n);

    void adjust();
}

class Wind implements Instrument {

    /**
     * Wind 类实现了 Instrument 接口，实现了 play 和 adjust 方法，
     * play 和 adjust 方法在 Instrument 中没有用修饰符修饰，但是默认是 public 的，
     * 当要实现一个接口时，在接口中被定义的方法，在实现类中必须被定义为是 public 的，
     * 一个方法如果被继承，那么它的访问权限不能被降低，比如，一个方法原本是 private 的，
     * 那么继承之后，它可以被 private, protected, public 修饰，
     * 但是如果一个方法原本是 protected 的，那么继承之后，
     * 可以被 protected 和 public 修饰，但是不能被 private 修饰。
     *
     * 为什么不能降低访问权限？
     *
     * 假设 B 继承 A 类，a 方法是继承的方法，B 重写了 a 方法
     * A test = new B();  调用 test.a() 方法，此时编译器会去寻找 A 类的 a 方法，
     * 然后再找 A 类的子类 B 类中有没有重写 a 方法，发现重写了，于是会调用 B 类的 a 方法，
     * 但是由于访问权限降低，无法调用 B 类的 a 方法，此时就会出错。
     *
     * 参考：https://www.oschina.net/question/244000_39528
     */
    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Percussion implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Stringed implements Instrument {
    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    /**
     * 这里的 tune 方法参数是 Instrument 接口类型，
     * 只要是实现了 Instrument 接口的类的对象，
     * 都可以传入这个方法，这样就有很大的灵活性，
     * 因为不用限制必须是某个类，或者必须是某个基类的子类。
     * 随便创建一个类，只要实现 Instrument 接口，
     * 再实现 Instrument 接口中的 play 和 adjust 方法，
     * 就可以传入 tune 方法。
     */
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        /**
         * 只要是实现了接口的类的对象，都可以传入接口数组
         */
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}

/*
输出；

chapter9.music5.Wind@4554617c.play() MIDDLE_C
chapter9.music5.Percussion@74a14482.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C

 */