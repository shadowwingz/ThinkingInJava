package chapter11;

import java.util.ArrayList;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 *
 * GrannySmith 澳洲青苹
 * Gala 节日
 * Fuji 红富士
 */
class GrannySmith extends Apple {

}

class Gala extends Apple {

}

class Fuji extends Apple {

}

class Braeburn extends Apple {

}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        /**
         * ArrayList<Apple> apples
         * 表示这个 ArrayList 中
         * 只可以存储 Apple 类型的对象（包括 Apple 的子类）。
         */
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c : apples) {
            System.out.println(c);
        }
    }
}

/*
输出：

chapter11.GrannySmith@4554617c
chapter11.Gala@74a14482
chapter11.Fuji@1540e19d
chapter11.Braeburn@677327b6

 */
