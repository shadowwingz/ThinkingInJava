package chapter3;

/**
 * Created by shadowwingz on 2018/5/15 0015.
 */
public class EqualsMethod {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        // equals 方法是继承自 Object 类的，默认是比较内存地址
        // Integer 类重写了 equals 方法，重写为 比较值
        System.out.println(n1.equals(n2));

        String s1 = "abc";
        String s2 = "abc";
        // Integer 类重写了 equals 方法，重写为 比较字符串中的每个字符是否相同
        System.out.println(s1 == s2);
    }
}

/*
输出：

true
true

 */