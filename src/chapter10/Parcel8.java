package chapter10;

/**
 * Created by shadowwingz on 2018/6/11 0011.
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        /**
         * 这里调用 new Wrapping(x) 就把 x 传入 Wrapping 的
         * 构造器中，Wrapping 的成员 i 被赋值 10，
         * 然后在匿名内部类的 value 方法中，
         * 调用 super.value() 获取到 Wrapping 的 i 值，
         * 再乘以 47。
         */
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // 这里的分号，不是指内部类结束，而是指 return 语句结束。
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }
}
