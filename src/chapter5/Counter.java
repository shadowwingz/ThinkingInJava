package chapter5;

/**
 * Created by shadowwingz on 2018/5/18 0018.
 *
 * i 首先会置为 0，然后变成 2，然后变成 7。
 * 对于所有基本类型和对象引用，包括在定义时已经指定初值的变量，这种情况都是成立的
 */
public class Counter {
    int i = 2;

    public Counter() {
        System.out.println(i);
        i = 7;
        System.out.println(i);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
    }
}
