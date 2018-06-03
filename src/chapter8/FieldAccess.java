package chapter8;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 */
class Super {

    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {

    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        /**
         * sup.field = 0 说明调用 sup.field，获取的是基类的 field 字段
         * sup.getField() = 1 说明调用 sup.getField()，
         * 调用的是子类 Sub 的 getField() 方法，获取的是子类 Sub 的 field 字段
         *
         * 说明：域（字段）是没有多态的，普通方法是有多态的
         *
         * 书中原话：
         * 当 Sub 对象转型为 Super 引用时，任何域访问操作都将由编译器解析，因此不是多态的。
         *
         * 个人理解：
         * 在访问域和方法时，编译器不知道域和方法是哪个类的，
         * 但是方法调用机制知道方法是哪个类的，但是方法调用机制并不负责域
         */
        System.out.println("sup.field = " + sup.field +
                ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " +
                sub.getField() + ", sub.getSuperField = " + sub.getSuperField());
    }
}

/*
输出：

sup.field = 0, sup.getField() = 1
sub.field = 1, sub.getField() = 1, sub.getSuperField = 0

 */