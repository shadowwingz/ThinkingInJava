package chapter14.toys;

/**
 * Created by shadowwingz on 2018-06-26 22:05
 */
interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

class Toy {
    /**
     * 如果把这个构造器注释掉，调用 newInstance 方法，就会报错。
     */
    Toy() {

    }

    Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            /**
             * 这里必须使用全限定名（包括包名）
             */
            c = Class.forName("chapter14.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        System.out.println();

        for (Class face : c.getInterfaces()) {
            printInfo(face);
            System.out.println();
        }
        System.out.println();

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            /**
             * 用 newInstance 方法，可以创建对象，
             * 前提是类带有默认的构造器。
             */
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

/*
输出：

Class name: chapter14.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name: chapter14.toys.FancyToy

Class name: chapter14.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name: chapter14.toys.HasBatteries

Class name: chapter14.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name: chapter14.toys.Waterproof

Class name: chapter14.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name: chapter14.toys.Shoots


Class name: chapter14.toys.Toy is interface? [false]
Simple name: Toy
Canonical name: chapter14.toys.Toy

 */