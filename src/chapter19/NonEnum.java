package chapter19;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            // 即使类不是 enum 对象，也可以调用 getEnumConstants 方法，
            // 只是会报空指针异常。
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*

输出：

java.lang.NullPointerException

 */