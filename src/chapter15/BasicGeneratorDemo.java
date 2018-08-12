package chapter15;

import mindview.util.Generator;

/**
 * Created by shadowwingz on 2018-08-12 19:38
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        /**
         * 创建 CountedObject 对象
         */
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
//        Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}

/*
输出：

CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4

 */