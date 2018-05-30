package chapter7;

/**
 * Created by shadowwingz on 2018/5/27 0027.
 *
 * 向上转型时，
 * 无法调用子类特有的方法，
 * 可以调用父类特有的方法
 * 如果调用父类和子类都有的方法，则实际上会调用子类的方法
 *
 * 相关问题：java继承中，为什么向上转型后无法运行子类中特有的方法？
 * https://segmentfault.com/q/1010000004558570
 *
 * 摘要：
 *
 * 是变量的声明类型决定了它能调用哪些方法，而不是它指向的堆中的对象的实际类型。
 * 
 */
// 乐器
class Instrument {

    public void play() {
        System.out.println("playInstrument");
    }

    public void playInstrument() {
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
//        Instrument.tune(flute);

        Instrument instrument = new Wind();
        /**
         * 调用父类和子类都有的方法，实际上调用的是子类的方法
         *
         * 输出：playWind
         */
        instrument.play();
        /**
         * 可以调用
         */
        instrument.playInstrument();

        /**
         * 无法调用子类特有的方法，也就是说，向上转型会丢失方法
         */
//        instrument.playWind();
    }

    public void play() {
        System.out.println("playWind");
    }

    public void playWind() {
    }
}
