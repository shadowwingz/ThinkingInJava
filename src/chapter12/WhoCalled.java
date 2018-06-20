package chapter12;

/**
 * Created by shadowwingz on 2018-06-20 21:14
 *
 * e.getStackTrace() 方法返回一个由栈轨迹中的元素所构成的数组，
 * 即从方法调用序列的第一个方法到抛出异常的那个方法。
 */
public class WhoCalled {

    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("-------------------------");
        g();
        System.out.println("-------------------------");
        h();
    }
}

/*
输出：

f
main
-------------------------
f
g
main
-------------------------
f
g
h
main


 */