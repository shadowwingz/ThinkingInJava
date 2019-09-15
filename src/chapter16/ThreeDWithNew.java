package chapter16;

import java.util.Arrays;

public class ThreeDWithNew {
    public static void main(String[] args) {
        /**
         * 第一个 2 表示 a 里面有 2 个二维数组，
         * 第二个 2 表示二维数组里有 2 个一维数组
         * 第三个 4 表示一维数组里有 4 个元素
         */
        int[][][] a = new int[2][2][4];
        /**
         * [
         *      [
         *          [0, 0, 0, 0],
         *          [0, 0, 0, 0]
         *      ],
         *      [
         *          [0, 0, 0, 0],
         *          [0, 0, 0, 0]
         *      ]
         * ]
         */
        /**
         * 我们只 new 了一个数组出来，并没有给它赋值，
         * 但是通过打印可以看出，基本类型的数组是有默认值的，默认值是 0。
         */
        System.out.println(Arrays.deepToString(a));
    }
}
