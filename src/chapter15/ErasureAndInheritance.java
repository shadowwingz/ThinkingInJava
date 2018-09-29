package chapter15;

/**
 * Created by shadowwingz on 2018-09-29 22:39
 */
class GenericBase<T> {
    private T element;

    public void set(T arg) {
        arg = element;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {

}

/**
 * Derived2 继承自 GenericBase，但是没有任何泛型参数
 */
class Derived2 extends GenericBase {

}

//class Derived3 extends GenericBase<?> {
//
//}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);
    }
}
