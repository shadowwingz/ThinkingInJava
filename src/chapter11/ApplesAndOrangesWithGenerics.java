package chapter11;

import java.util.ArrayList;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        /**
         * ArrayList<Apple> apples
         * 表示这个 ArrayList 中
         * 只可以存储 Apple 类型的对象（包括 Apple 的子类）。
         */
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        /**
         * 因为 apples 中只可以存储 Apple 类型的对象，
         * 所以无法存储 Orange 类型的对象。
         */
//        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            /**
             * 因为 ArrayList<Apple> 已经指定 apples 中只可以存储 Apple 类型的对象，
             * 所以从 apples 中 get 元素时，List 会帮我们执行向下转型，不需要我们手动去向下转型了。
             * 注意，此时 get 元素，取出的依然是 Object 对象，
             * 只是 List 会帮我们向下转型为 Apple 对象。
             */
            Apple apple = apples.get(i);
            System.out.println(apples.get(i).id());
        }
        for (Apple c : apples) {
            System.out.println(c.id());
        }
    }
}
