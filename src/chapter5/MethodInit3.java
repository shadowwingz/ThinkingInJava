package chapter5;

/**
 * Created by shadowwingz on 2018/5/18 0018.
 */
public class MethodInit3 {
    int i = f();
    int j = g(i);
    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
}
