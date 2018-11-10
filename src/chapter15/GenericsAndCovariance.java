package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-11-08 22:18
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        /**
         * List<Fruit> 表示 一个 list，持有 Fruit 的某种类型，
         * List<? extends Fruit> 表示一个 List，持有某种类型，这个类型可以是继承了 Fruit 的某种类型。
         *
         * 区别：
         * List<Fruit> 知道自己持有的是 Fruit 的某种类型，
         * List<? extends Fruit> 不知道自己持有的到底是什么类型，
         * 可能是 Fruit 的某种类型，也可能是 Fruit 的子类（Apple）的某种类型。
         * 正是因为这种不确定，所以不能添加 Fruit, Apple 等任何类型。
         * 因为
         * 如果持有的是 Apple，那只能添加 Apple 及 Apple 的子类，这时添加 Fruit 或 Orange 或 Object 类型就会报错。
         * 如果持有的是 Orange，那只能添加 Orange 及 Orange 的子类，这时添加 Fruit 或 Apple 或 Object 类型就会报错。
         */
        List<? extends Fruit> flist = new ArrayList<>();
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null);
        /**
         * 调用 flist.get(0)，会返回 Fruit 类型，
         * 因为不管它实际的类型到底是什么，但肯定能转型为 Fruit，所以编译器允许返回 Fruit。
         */
        Fruit f = flist.get(0);
    }
}
