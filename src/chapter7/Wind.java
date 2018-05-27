package chapter7;

/**
 * Created by shadowwingz on 2018/5/27 0027.
 */
// 乐器
class Instrument {

    public void play() {
    }

    // 调试
    static void tune(Instrument i) {
        i.play();
    }
}

// 管乐器
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        /**
         * Instrument 的 tune 方法的参数类型本来是 Instrument 类型，
         * 这里我们传入 Instrument 的子类，也就是 Wind，
         * 编译器会自动把 Wind 转换为 Instrument（向上转型）
         */
        Instrument.tune(flute);
    }
}
