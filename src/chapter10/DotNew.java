package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 */
public class DotNew {

    public class Inner {

    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        /**
         * 使用 .new 语法来创建，
         * 不需要引用外部类的名字 DotNew，
         * 即不需要这么写（也不能这么写）：
         * dn.new DotNew.Inner()
         */
        DotNew.Inner dni = dn.new Inner();
    }
}
