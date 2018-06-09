package chapter9;

import java.util.Random;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 *
 * RAND，RANDOM_INT，RANDOM_LONG，RANDOM_FLOAT，RANDOM_DOUBLE
 * 这些变量（严格来说是常量）不是接口的一部分，
 * 它们的值被存储在该接口的静态存储区域内。
 */
public interface RandVals {

    Random RAND = new Random(47);

    int RANDOM_INT = RAND.nextInt(10);

    long RANDOM_LONG = RAND.nextLong() * 10;

    float RANDOM_FLOAT = RAND.nextLong() * 10;

    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
