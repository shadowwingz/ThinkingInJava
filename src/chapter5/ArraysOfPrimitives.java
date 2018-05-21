package chapter5;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
// primitive 原始
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        // 把 a1 引用赋值给 a2，所以 a2 也指向了 a1 数组
        // 此时，操作 a2 相当于操作 a1
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1[" + i + "] : " + a1[i]);
        }
    }
}

/*
输出：

a1[0] : 2
a1[1] : 3
a1[2] : 4
a1[3] : 5
a1[4] : 6


 */
