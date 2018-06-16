package chapter11;

import java.util.ArrayList;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 *
 * ArrayList 默认保存的是 Object，无论是 add Apple 对象，
 * 还是 add Orange 对象，保存到 ArrayList 时都会向上转型为 Object 对象。
 * 当使用 ArrayList 的 get 方法取出对象时，取出的只是一个 Object 对象，
 * 需要向下转型为合适的对象。如果向下转型失败就会报 ClassCastException 异常。
 */
class Apple {

    private static long counter;

    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {

}

public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            ((Apple) apples.get(i)).id();
        }
    }
}

/*
输出；

Exception in thread "main" java.lang.ClassCastException:
chapter11.Orange cannot be cast to chapter11.Apple

 */
