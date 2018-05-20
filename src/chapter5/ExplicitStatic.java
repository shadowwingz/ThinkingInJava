package chapter5;

/**
 * Created by shadowwingz on 2018/5/20 0020.
 *
 * static {
 * }
 *
 * 上面的代码看起来像个方法，但它实际上只是一段跟在 static 关键字后面的代码。
 * 和其他静态初始化一样，这段代码仅执行一次：当首次生成这个类的一个对象时，
 * 或者首次访问属于那个类的静态数据成员时（即便没有生产过那个类的对象）
 */
class Cup {
    public Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    // 即使 Cups 对象被创建多次，cup1, cup2 对象也只会被初始化一次
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    static {
        System.out.println("static");
    }

    public Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        // 调用 Cups.cup1，会执行 Cups 类的静态初始化语句，从而创建 cup1 对象，
        // 也就是说，获取类的一个静态对象，会导致类的所有静态初始化语句被执行
        Cups.cup1.f(99);
//        Cup cup1 = Cups.cup2;
//        System.out.println(cup1);
    }

//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();
}

/*
输出：

Inside main()
Cup(1)
Cup(2)
static
f(99)

 */