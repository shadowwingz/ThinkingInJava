package chapter14;

/**
 * Created by shadowwingz on 2018-06-26 23:54
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        /**
         * Class 引用指向的是 int.class，
         * 所以可以用 Class<Integer> 泛型来把 Class 类型变的更具体。
         */
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
        /**
         * 泛型类引用只能赋值为指向其声明的类型（这里是 Integer）
         */
//        genericIntClass = double.class;
    }
}
