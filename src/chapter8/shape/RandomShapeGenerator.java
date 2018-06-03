package chapter8.shape;

import java.util.Random;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 *
 * 向上转型是在 return 语句里发生的
 * 因为返回哪个子类是由 rand 来随机决定的，
 * 所以我们调用 next 方法时，
 * 是不知道返回的到底是哪个子类，
 * 所以这也说明，我们只能获取一个通用的 shape 引用
 */
public class RandomShapeGenerator {

    private Random rand = new Random(47);

    public Shape next() {
        switch (rand.nextInt(3)) {
            default: {

            }
            case 0: {
                return new Circle();
            }
            case 1: {
                return new Square();
            }
            case 2: {
                return new Triangle();
            }
        }
    }
}
