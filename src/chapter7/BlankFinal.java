package chapter7;

/**
 * Created by shadowwingz on 2018/6/1 0001.
 *
 * 空白 final，是指 定义时没有初始化的变量，
 * 空白 final 并不是说一个 final 修饰的变量可以不初始化，
 * 只是可以延迟初始化，比如在构造器中
 */
class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private final int i = 0;
    /**
     * j 和 p 是空白 final，
     * 从这里也可以看出，空白 final 可以
     * 是基本类型，也可以是类
     */
    private final int j;
    private final Poppet p;

    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    public BlankFinal(int x) {
        j = x;
        p = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
