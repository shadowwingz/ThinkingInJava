package chapter15;

/**
 * Created by shadowwingz on 2018-08-19 17:39
 */
class Manipulator<T> {

    /**
     * 这里的泛型 T，在运行时 T 的具体类型会被擦除，
     * 也就是说，假如 T 是 String，在运行时我们不知道它是 String。
     */
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        /**
         * 这里我们调用 obj.f() 方法，假如 T 是 HasF 类型（ HasF 有 f() 方法），
         * 那么这里应该是可以调用的。但是由于在运行时 T 的具体类型会被擦除，
         * 所以 obj 并不是 HasF 类型。所以也就不能调用 f() 方法。
         */
//        obj.f();
    }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
