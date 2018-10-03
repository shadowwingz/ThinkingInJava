package chapter15;

/**
 * Created by shadowwingz on 2018-10-04 0:02
 */
class Building {

}

class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        /**
         * 个人理解
         *
         * public ClassTypeCapture(Class<T> kind)
         * 引入类型标签，也就是 Class，当我们传入 Building.class 时，
         * 虽然 T 被擦除，但是类型信息会被存入 Class 中。
         */
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}

/*
输出：

true
true
false
true

 */