package chapter15;

/**
 * Created by shadowwingz on 2018-07-06 23:23
 */
public class Holder2 {

    /**
     * Holder2 可以存储任何类型的对象
     */
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public static void main(String[] args) {
        /**
         * 存储 Automobile 类型的对象
         */
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        /**
         * 存储 String 类型的对象
         */
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        /**
         * 存储 Integer 类型的对象
         */
        h2.set(1);
        Integer x = (Integer) h2.get();
    }
}
