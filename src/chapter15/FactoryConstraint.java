package chapter15;

/**
 * Created by shadowwingz on 2018-10-04 0:40
 */
interface FactoryI<T> {
    T create();
}

class Foo2<T> {
    private T x;

    /**
     * 构造器的形参是 F 类型，F extends FactoryI，
     * 说明 F 是 FactoryI 或 FactoryI 的子类，
     * 也就是说，创建 Foo2 对象，需要传入 FactoryI 或 FactoryI 子类的实例。
     */
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}
