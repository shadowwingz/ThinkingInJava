package chapter15;

/**
 * Created by shadowwingz on 2018-08-12 17:36
 * <p>
 * 可以只定义泛型方法，而不用把整个类都变成泛型。
 */
public class GenericMethods {

    /**
     * 平常我们定义方法是这样的，方法的形参
     * 是 int 类型，返回值是 void 类型。
     */
//    public void f(int i) {
//
//    }

    /**
     * 泛型方法要把泛型参数类型 <T> 放在返回值 void 之前，
     * 这里方法的形参也是泛型 T，形参是 T 类型，
     * 这意味着 f() 方法可以接收任意类型的对象。
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        /**
         * 使用泛型类时，必须在创建对象的时候指定类型参数的值，
         * RandomList<String> rs = new RandomList<>();
         * 比如创建 RandomList 对象的时候，指定类型参数为 String。
         * 而是用泛型方法的时候，通常不必指定参数类型，
         * 比如下面调用的 gm.f() 方法。
         *
         * 另外，当调用 gm.f() 方法时，传入基本类型，
         * 自动打包机制会帮我们把基本类型转换为对应的对象，
         * 比如 int 转换为 Integer。
         */
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}

/*
输出：

java.lang.String
java.lang.Integer
java.lang.Double
java.lang.Float
java.lang.Character
chapter15.GenericMethods

 */