package chapter14;

/**
 * Created by shadowwingz on 2018-06-29 19:40
 *
 * A instanceof B
 * 如果 A 类就是 B 类，或者 A 类是 B 类的子类，那么结果是 true
 *
 * A == B 和 A equals B
 * 只有 A 类就是 B 类，结果才是 true。
 *
 * instanceof 会考虑继承，== 不会考虑。
 */
class Base {

}

class Derived extends Base {

}

public class FamilyVsExactType {

    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base  " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println();
        test(new Derived());
    }
}

/*
输出：

Testing x of type class chapter14.Base
x instanceof Base  true
x instanceof Derived false
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class) true
x.getClass().equals(Derived.class) false

Testing x of type class chapter14.Derived
x instanceof Base  true
x instanceof Derived true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class) false
x.getClass().equals(Derived.class) true

 */