package chapter13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-06-25 21:45
 *
 * 当在 toString 方法里打印 this 时，可能会发生递归。
 */
public class InfiniteRecursion {

    @Override
    public String toString() {
        /**
         * 调用
         *
         * " InfiniteRecursion address: " + this
         *
         * ，当编译器看到一个 String 对象后面跟着一个 + 号，
         * + 号后面的对象不是 String，于是编译器会尝试
         * 调用 this.toString() 方法将 this 转换为 String，
         * 于是就发生了递归调用。
         *
         * 如果真的想打印对象的内存地址，应该调用 Object
         * 的 toString 方法，也就是 super.toString()
         */
        return " InfiniteRecursion address: " + this + "\n";
//        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
