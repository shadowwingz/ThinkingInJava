package chapter16;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {
    public static void main(String[] args) {
        Random rand = new Random(47);
        // 到这里，只确定了第一维的长度，也就是 rand.nextInt(7) 的值
        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            // 到这里，确定了第二维的长度
            a[i] = new int[rand.nextInt(5)][];
            for (int j = 0; j < a[i].length; j++) {
                // 到这里，确定了第三维的长度
                a[i][j] = new int[rand.nextInt(5)];
            }
        }
        /**
         * 从输出可以看到，每一维的数组中的元素数量都可能不一样，
         * 这被称为粗糙数组。
         */
        System.out.println(Arrays.deepToString(a));
    }
}

/*

输出：

[
    [],
    [
        [0],
        [0],
        [0, 0, 0, 0]
    ],
    [
        [],
        [0, 0],
        [0, 0]
    ],
    [
        [0, 0, 0],
        [0],
        [0, 0, 0, 0]
    ],
    [
        [0, 0, 0],
        [0, 0, 0],
        [0], []
    ],
    [
        [0],
        [],
        [0]
    ]
]


 */