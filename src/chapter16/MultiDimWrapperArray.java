package chapter16;

import java.util.Arrays;

/**
 * Arrays.deepToString 方法对基本类型数组和对象数组都适用。
 */
public class MultiDimWrapperArray {
    public static void main(String[] args) {
        // 基本类型数组 + 自动包装
        Integer[][] a1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        // 基本类型数组 + 自动包装
        Double[][][] a2 = {
                {
                        {1.1, 2.2},
                        {3.3, 4.4},
                },
                {
                        {5.5, 6.6},
                        {7.7, 8.8}
                }
        };
        // 对象数组
        String[][] a3 = {
                {
                        "The", "Quick", "Sly", "Fox"
                },
                {
                        "Jumped", "Over"
                },
                {
                        "The", "Lazy"
                }
        };
        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a2: " + Arrays.deepToString(a2));
        System.out.println("a3: " + Arrays.deepToString(a3));
    }
}

/*

输出：

a1: [[1, 2, 3], [4, 5, 6]]
a2: [[[1.1, 2.2], [3.3, 4.4]], [[5.5, 6.6], [7.7, 8.8]]]
a3: [[The, Quick, Sly, Fox], [Jumped, Over], [The, Lazy]]

 */