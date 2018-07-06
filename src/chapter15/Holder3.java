package chapter15;

/**
 * Created by shadowwingz on 2018-07-06 23:32
 * <p>
 * 暂时不指定类型，稍后再决定具体使用什么类型。
 * 使用类型参数，用尖括号括住，放在类型后面。
 * 比如下面例子中的 T。
 */
public class Holder3<T> {

    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        /**
         * 当创建 Holder3 对象时，必须指明想持有什么类型的对象，把它放在尖括号中。
         * 这里我们指明想持有 Automobile 类型的对象。
         */
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        /**
         * 我们从 Holder3 中取出它持有的对象，
         * 这个对象自动地就是正确的类型（Automobile 类型），
         * 不需要我们再手动转型。
         */
        Automobile a = h3.get();
    }
}
