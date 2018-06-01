package chapter7;

/**
 * Created by shadowwingz on 2018/6/1 0001.
 *
 * final 修饰的类无法被继承
 *
 * 由于 final 类禁止继承，所以 final 类中所有的方法都隐式指定为是 final 的，
 * 因为无法覆盖它们（不能继承类，还怎么覆盖类的方法）
 */
// 小脑
class SmallBrain {
}

// 恐龙
final class Dinosaur {
    int i = 7;
    int j = 1;

    SmallBrain x = new SmallBrain();

    void f() {
    }
}

// final 修饰的类无法被继承
//class Further extends Dinosaur {}

// 侏罗纪
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
