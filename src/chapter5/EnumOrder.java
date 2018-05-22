package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 */
// ordinal 序数词
public class EnumOrder {
    public static void main(String[] args) {
        // Enum.values() 方法，按照 enum 常量的声明顺序，
        // 产生由这些常量值构成的数组
        for (Spiciness s : Spiciness.values()) {
            // ordinal 方法，表示某个特定 enum 变量的声明顺序
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}

/*
输出：

NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4

 */
