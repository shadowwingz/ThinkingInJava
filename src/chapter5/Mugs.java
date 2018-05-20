package chapter5;

/**
 * Created by shadowwingz on 2018/5/20 0020.
 *
 * {
 *
 * }
 *
 * 这个语法被称为实例初始化，用来初始化每一个对象的非静态变量，
 * 另外，它可以保证，无论你调用了哪个构造方法来创建对象，这个方法都会被执行
 */
// 杯
class Mug {
    public Mug(int marker) {
        System.out.println("Mug(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

public class Mugs {
    // mug1 和 mug2 不是静态变量，
    // 所以当调用 new Mugs() 时，mug1 和 mug2 会被初始化一次，
    // 当调用 new Mugs(1) 时，mug1 和 mug2 又被初始化一次
    Mug mug1;
    Mug mug2;

    // 在 {} 代码块里初始化 mug1 和 mug2

    // 调用 new Mugs() 和 new Mugs(1) 时，
    // 这个代码块里的语句都被执行了
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized");
    }

    public Mugs() {
        System.out.println("Mugs()");
    }

    public Mugs(int i) {
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");
    }
}

/*
输出：

Inside main()
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs()
new Mugs() completed
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs(int)
new Mugs(1) completed

 */