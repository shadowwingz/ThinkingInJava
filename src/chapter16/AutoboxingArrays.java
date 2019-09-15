package chapter16;

import java.util.Arrays;

public class AutoboxingArrays {
    public static void main(String[] args) {
        /**
         * 自动包装机制对数组初始化也起作用，
         * 定义的时候是 int，被包装成了 Integer。
         */
        Integer[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10, 11, 12},
        };
        System.out.println(Arrays.deepToString(a));
    }
}

/*

输出：

[
    [1, 2, 3, 4, 5],
    [6, 7, 8, 9, 10, 11, 12]
]

 */