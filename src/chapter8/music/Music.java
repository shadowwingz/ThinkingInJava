package chapter8.music;

/**
 * Created by shadowwingz on 2018/6/2 0002.
 */
public class Music {
    /**
     * tune 方法接收 Instrument 对象的引用
     * 或者 Instrument 子类的对象的引用，
     * 因为 Instrument 有 play 方法，
     * 那么 Instrument 的子类肯定也有 play 方法，
     * 这里不需要类型转换
     */
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}

/*
输出：

Wind.play() MIDDLE_C

 */
