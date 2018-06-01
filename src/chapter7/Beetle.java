package chapter7;

/**
 * Created by shadowwingz on 2018/6/1 0001.
 *
 * 初始化顺序：
 *
 * 父类 static 变量
 * 子类 static 变量
 * 父类对象的基本类型和对象引用
 * 子类对象的基本类型和对象引用
 * 父类构造器
 * 子类构造器
 *
 * 如果一个类中有多个 static 变量和 static 代码块，
 * static 变量和 static 代码块的初始化顺序和定义类时的书写顺序一致
 */
// 昆虫
class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

// 甲虫
public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}

/*
输出：

static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39

 */