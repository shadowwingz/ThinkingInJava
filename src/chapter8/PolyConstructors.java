package chapter8;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 *
 * 初始化的实际过程是：
 * (1)把字段都初始化为初始值，int 类型初始化为 0，对象初始化为 null
 * (2)调用基类构造器（Glyph()），此时，调用被覆盖后的 draw() 方法，
 * 由于步骤 1 的缘故，radius 的值是 1
 * (3)按照声明的顺序调用成员的初始化方法
 */
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        /**
         * 在这里打断点可以知道，代码执行到这里时，
         * RoundGlyph 的 radius 的值是 0
         */
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

/*
输出：

Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5

 */
