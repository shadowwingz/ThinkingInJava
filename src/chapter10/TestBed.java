package chapter10;

/**
 * Created by shadowwingz on 2018/6/13 0013.
 */
public class TestBed {

    public void f() {
        System.out.println("f()");
    }

    /**
     * 把测试代码放在嵌套类中
     */
    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}

/*
输出：

f()

 */