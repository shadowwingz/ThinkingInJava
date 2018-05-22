package chapter5;

/**
 * Created by shadowwingz on 2018/5/22 0022.
 *
 * 在可变参数列表中可以使用任何类型的参数，包括基本类型
 */
public class VarargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        // 这里调用了 args.length 方法，length 方法是数组才有的方法，
        // 所以，这里也可以看出，虽然我们传递的是可变参数列表，
        // 但是编辑器实际上会帮你填充数组，
        // 也就是说，你拿到的 args 对象实际上是个数组
        // 如果我们没有传参数，那么 args 对象是个空数组
        System.out.println(" length " + args.length);
    }

    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        // getClass 是 Object 类的方法，它将产生对象的类
        // 打印该类时，前面的 [ 表示这是一个后面紧随的类型的数组
        // 后面的 I 表示基本类型 int
        // 后面的 Ljava.lang.Integer 表示包装器类型 Integer
        // 这也说明了，可变参数列表不会帮我们进行自动装箱
        System.out.println("int[]: " + new int[0].getClass());
        System.out.println("int[]: " + new Integer[0].getClass());
    }
}

/*
输出：

class [Ljava.lang.Character; length 1
class [Ljava.lang.Character; length 0
class [I length 1
class [I length 0
int[]: class [I
int[]: class [Ljava.lang.Integer;

 */
