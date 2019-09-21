package chapter19;

enum Search {
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        // Search 对象向上转型为 Enum 对象
        Enum e = Search.HITHER;
        // 由于 values 方法是编译期添加的方法，不是 Enum 自带的方法，
        // 所以 Search 对象向上转型为 Enum 对象之后，就无法调用 values 方法了。
//        e.values();
        // 即使没有 values 方法获取所有 enum 实例，
        // 我们也可以通过 enum.getClass.getEnumConstants 方法获取所有 enum 实例。
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}

/*

输出：

HITHER
YON

 */