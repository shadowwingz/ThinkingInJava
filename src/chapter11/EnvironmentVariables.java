package chapter11;

import java.util.Map;

/**
 * Created by shadowwingz on 2018-06-18 23:02
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        /**
         * System.getenv() 返回一个 Map，
         * entrySet() 返回一个由 Map.Entry 的元素构成的 Set，
         * 并且这个 Set 是一个 Iterable，因此它可以用于 foreach 循环。
         */
        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
