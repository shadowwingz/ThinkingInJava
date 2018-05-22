package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 */
// trailing 尾随
public class OptionalTrailingArguments {
    static void f(int required, String... trailing) {
        System.out.print("required: " + required + " ");
        for (String s : trailing) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(1, "one");
        f(2, "two", "three");
        f(0);
    }
}

/*
输出：

required: 1 one
required: 2 two three
required: 0

 */
