package chapter14.toys;

/**
 * Created by shadowwingz on 2018-06-27 22:28
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        /**
         * 在泛型里指明了 Class 类型是 FancyToy，
         * 这种情况下调用 newInstance 方法得到的就是 FancyToy 对象。
         */
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        /**
         * FancyToy 的父类是 Toy，但是调用 getSuperclass 得到的却是 ? super FancyToy，
         * 调用 newInstance 方法，得到的是 Object，而不是 Toy。
         */
        Class<? super FancyToy> up = ftClass.getSuperclass();
//        Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
    }
}
