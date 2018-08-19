package chapter15;

/**
 * Created by shadowwingz on 2018-08-19 17:42
 * <p>
 * 边界 <T extends HasF> 声明 T 必须是 HasF 或者 HasF 的子类。
 * 这样，我们就可以调用 obj.f() 方法了。
 */
public class Manipulator2<T extends HasF> {

    private T obj;

    public Manipulator2(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}
