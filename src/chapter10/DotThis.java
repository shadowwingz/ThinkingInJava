package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 * <p>
 * “类名.this”的语法在 Java 语言中叫做 “qualified this”。
 * 这个语法的主要用途是：
 * 在内部类的方法中，要指定某个嵌套层次的外围类的“this”引用时，
 * 使用“外围类名.this”语法。
 */
public class DotThis {

    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            /**
             * 使用外部类的名字后面紧跟圆点和 this 来引用外部类对象
             */
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}

/*
输出：

DotThis.f()

 */