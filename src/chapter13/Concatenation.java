package chapter13;

/**
 * Created by shadowwingz on 2018-06-24 22:24
 *
 * 操作符 + 可以用来连接 String
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
