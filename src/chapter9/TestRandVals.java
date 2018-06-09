package chapter9;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 *
 * main 是静态方法，由于静态方法中不能引用非静态变量，
 * 所以，如果可以输出下面的值，就可以证明接口中的变量是 static 的
 */
public class TestRandVals {

    public static void main(String[] args) {
        System.out.println(RandVals.RANDOM_INT);
        System.out.println(RandVals.RANDOM_LONG);
        System.out.println(RandVals.RANDOM_FLOAT);
        System.out.println(RandVals.RANDOM_DOUBLE);
    }
}

/*
输出：

8
-32032247016559954
-8.5939291E18
5.779976127815049

 */