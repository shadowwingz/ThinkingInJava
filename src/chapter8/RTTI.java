package chapter8;

/**
 * Created by shadowwingz on 2018/6/4 0004.
 */
class Useful {
    public void f() {

    }

    public void g() {

    }
}

class MoreUseful extends Useful {
    public void f() {

    }

    public void g() {

    }

    public void u() {

    }

    public void v() {

    }

    public void w() {

    }
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x= {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        /**
         * x[1] 没有向下转型为 MoreUseful，所以不能调用 MoreUseful 的方法
         */
//        x[1].u();
        ((MoreUseful) x[1]).u();
        /**
         * x[0] 虽然向下转型为 MoreUseful，但它本身并不是 MoreUseful，所以会报异常
         */
//        ((MoreUseful) x[0]).u();
    }
}
