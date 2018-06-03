package chapter8.music3;

import chapter8.music.Note;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 *
 * orchestra 乐队
 */
class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    String what() {
        return "Wind";
    }

    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    String what() {
        return "Percussion";
    }

    void adjust() {
        System.out.println("Percussion Wind");
    }
}

class Stringed extends Instrument {
    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    String what() {
        return "Stringed";
    }

    void adjust() {
        System.out.println("Stringed Wind");
    }
}

class Brass extends Wind {
    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    String what() {
        return "Brass";
    }

    void adjust() {
        System.out.println("Brass Wind");
    }
}

class Woodwind extends Wind {
    void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    String what() {
        return "Woodwind";
    }

    void adjust() {
        System.out.println("Woodwind Wind");
    }
}

public class Music3 {

    /**
     * tune 方法接收 Instrument 类型的参数，我们随便新建类，
     * 只要继承自 Instrument，都可以传入 tune 方法，
     * 而 tune 方法不需要做任何修改，这就是扩展性
     */
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        /**
         * 把 Instrument 子类对象的引用放入 orchestra 数组中，
         * Instrument 子类对象会自动向上转型为 Instrument
         */
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        /**
         * 在 tuneAll 方法中，调用 tune 方法，
         * 方法调用机制会自动识别出 tune 方法应该传入哪个子类
         */
        tuneAll(orchestra);
    }
}

/*
输出：

Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C

 */
