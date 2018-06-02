package chapter8.music;

/**
 * Created by shadowwingz on 2018/6/2 0002.
 * <p>
 * Stringed 弦
 * Brass 低音
 * flute 长笛
 * violin 小提琴
 * frenchHorn 法国号角
 *
 * 如果不用多态，即 Music2 的 tune 方法的形参是具体类型
 * （Instrument 的某个子类），而不是 Instrument 类型，
 * 这时调用 tune 方法，要想输出 Wind.play() MIDDLE_C 必须传入 Wind 类型，
 * 要想输出 Stringed.play() MIDDLE_C 必须传入 Stringed 类型。
 *
 * 试想一下，如果能只写一个方法，
 * 我们不管传入 Instrument 的哪个子类，
 * 它都能正确接收，这样不就方便多了。
 * 而这，就是多态。
 */
class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
}

class Brass extends Instrument {
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
}

public class Music2 {
    public static void tune(Wind i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Stringed i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tune(Brass i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}

/*
输出：

Wind.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C

 */
