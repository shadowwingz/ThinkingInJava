package chapter14;

/**
 * Created by shadowwingz on 2018-06-27 0:04
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        /**
         * 使用通配符 “ ？ ”，表示任何事物
         *
         * Class<?> 和 Class 是等价的，但是 Class<?> 要好一些，
         * 它表示你并非是碰巧或者由于疏忽，而使用了一个非具体的类引用，
         * 你就是选择了非具体的版本。
         */
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
