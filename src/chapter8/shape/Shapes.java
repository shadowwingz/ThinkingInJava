package chapter8.shape;

/**
 * Created by shadowwingz on 2018/6/3 0003.
 *
 * 书中原话：
 * 在编译时，编译器不需要获得任何特殊信息就能进行正确的调用，
 * 对 draw() 方法的所有调用都是通过动态绑定进行的
 *
 * 个人理解：
 * 在调用基类的某个方法时，编译器并不知道此时的基类引用的是基类自身，
 * 还是它的哪个子类，它只管调用，但是方法调用机制会确保调用的是正确的那个类的方法
 */
public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++) {
            /**
             * gen.next() 方法每次都会返回一个 Shape 对象的引用，
             * 注意，这里返回的不是 Shape 子类对象的引用，
             * 尽管 gen.next() 方法中 new 的是 Shape 的子类
             */
            s[i] = gen.next();
        }
        for (Shape shape : s) {
            /**
             * 这里调用 shape.draw() 时，编译器并不知道
             * 此时的 shape 是 Circle 还是 Square 还是 Triangle，
             * 但是方法调用机制知道，并调用对应子类的 draw() 方法
             */
            shape.draw();
        }
    }
}

/*
输出：

Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()

 */
