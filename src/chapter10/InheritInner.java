package chapter10;

/**
 * Created by shadowwingz on 2018/6/15 0015.
 *
 * 内部类的继承
 */
class WithInner {
    class Inner {

    }
}

public class InheritInner extends WithInner.Inner {

    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
