package chapter5;

/**
 * Created by shadowwingz on 2018/5/18 0018.
 *
 * 在类的内部，变量定义的先后顺序决定了初始化的顺序。
 * 即使变量定义散布于方法定义之间，
 * 它们仍旧会在任何方法（包括）构造器被调用之前得到初始化。
 */
class Window {
    public Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    // w1 最先被定义，所以最先初始化
    Window w1 = new Window(1);
    // 变量都初始化完，才开始调用构造方法，
    // 所以构造方法第四个被初始化
    // 此时 w3 又被初始化一次
    House() {
        System.out.println("House");
        w3 = new Window(33);
    }
    // w2 第二个被定义，所以第二个初始化
    Window w2 = new Window(2);
    // 普通方法在构造方法之后被调用，所以第五个被初始化
    void f() {
        System.out.println("f()");
    }
    // w3 第三个被定义，所以第三个初始化
    Window w3 = new Window(3);
}

public class OrderOfInitialization {
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}
