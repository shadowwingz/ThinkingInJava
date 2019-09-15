package chapter16;

import java.util.Arrays;

public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        /**
         * a 是个多维数组，里面包含 2 个数组，
         * 一个是 {1, 2, 3}，一个是 {4, 5, 6}
         */
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
        };
        /**
         * deepToString 方法，可以将多维数组转换为多个 String
         */
        System.out.println(Arrays.deepToString(a));
    }
}

/*

输出：

[[1, 2, 3], [4, 5, 6]]

 */