package chapter15;

/**
 * Created by shadowwingz on 2018-10-17 22:52
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;

    static Generic<Integer>[] gia;

    public static void main(String[] args) {
//        gia = (Generic<Integer>[]) new Object[SIZE];
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
//        gia[1] = new Object();
//        gia[2] = new Generic<Double>();
    }
}

/*
输出：

Generic[]

 */