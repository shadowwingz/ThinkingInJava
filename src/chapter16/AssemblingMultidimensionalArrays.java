package chapter16;

import java.util.Arrays;

public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                /**
                 * 动态构建非基本类型的对象数组，
                 * 数组的值是在 for 循环中动态生成的。
                 */
                a[i][j] = i * j;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}

/*

输出：

[
    [0, 0, 0],
    [0, 1, 2],
    [0, 2, 4]
]

 */