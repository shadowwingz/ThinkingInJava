package chapter7;

/**
 * Created by shadowwingz on 2018/5/10 0010.
 *
 * Homer 类中重载了 doh 方法，
 * Bart 继承了 Homer 类，并重写了 doh 方法，
 * 但是 Homer 类的 doh 方法仍然可以调用
 *
 * 调用 doh 方法时，会先去查找 Bart 类中
 * 有没有符合的 doh 方法，如果有，就调用 Bart 类的，
 * 如果没有，就调用 Homer 类的（如果 Homer 类中有符合的）
 */
class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }

    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {

}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        // 调用 Homer 的 doh 方法
        b.doh(1);
        // 调用 Homer 的 doh 方法
        b.doh('x');
        // 调用 Homer 的 doh 方法
        b.doh(1.0f);
        // 调用 Bart 的 doh 方法
        b.doh(new Milhouse());
    }
}

/*
输出：

doh(float)
doh(char)
doh(float)
doh(Milhouse)

 */