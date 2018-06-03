package chapter8;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 * <p>
 * SandWich 三明治
 * <p>
 * （1）首先，访问 SandWich 的 main 方法（这是一个 static 方法），
 * 于是装载器就会为你寻找已经编译的 SandWich 类的代码（也就是 SandWich.class 文件）。
 * 在装载的过程中，装载器注意到它有一个基类（也就是extends所要表示的意思），
 * 于是它再装载基类。不管你创不创建基类对象，这个过程总会发生。如果基类还有基类，
 * 那么第二个基类也会被装载，依此类推。
 * <p>
 * （2）执行基类的 static 初始化，然后是下一个子类的 static 初始化，
 * 依此类推。这个顺序非常重要，因为子类的“static初始化”有可能要依赖基类成员的正确初始化。
 * <p>
 * （3）当所有必要的类都已经装载结束，开始执行 main() 方法体，并用 new SandWich() 创建对象。
 * <p>
 * (4)类 SandWich 存在父类，则调用父类的构造函数，你可以使用 super 来指定调用哪个构造函数。
 * 基类的构造过程以及构造顺序，同子类的相同。首先基类中各个变量按照字面顺序进行初始化，然
 * 后执行基类的构造函数的其余部分。
 * <p>
 * (5)对子类成员数据按照它们声明的顺序初始化，执行子类构造函数的其余部分。
 *
 * 参考：https://segmentfault.com/a/1190000004527951
 *
 * 在本例中，先加载 main 方法，然后调用 new SandWich()，这时发现 SandWich 有父类，
 * 于是一层层向上找，最后找到了 Meal，然后一层层向下初始化，
 * 先初始化 Meal 的成员变量，再调用 Meal 的构造器，
 * 再初始化 Lunch 的成员变量，再调用 Lunch 的构造器，
 * 再初始化 PortableLunch 的成员变量，再调用 PortableLunch 的构造器，
 * 再初始化 SandWich 的成员变量，再调用 SandWich 的构造器。
 */
class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {

    private Bread b = new Bread();

    PortableLunch() {
        System.out.println("PortableLunch");
    }
}

public class SandWich extends PortableLunch {

    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public SandWich() {
        System.out.println("SandWich()");
    }

    public static void main(String[] args) {
        new SandWich();
    }
}

/*
输出：

Meal()
Lunch()
PortableLunch
Bread()
Cheese()
Lettuce
SandWich()

 */
