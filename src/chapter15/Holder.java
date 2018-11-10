package chapter15;

/**
 * Created by shadowwingz on 2018-11-08 23:13
 * <p>
 * set 方法接受类型参数 T 的对象作为参数，get 方法返回一个 T 类型对象，
 * 而 equals 方法接受一个 Object 作为参数。
 * fruit 的类型是 <? extends Fruit>，所以 set 方法不会接受任何对象的添加，
 * 但是 equals 方法可以正常工作。
 */
public class Holder<T> {

    private T value;

    public Holder() {
    }

    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        // apple 的泛型是 Apple
        Holder<Apple> apple = new Holder<>(new Apple());
        // 从 apple 中取出的元素就是 Apple 类型
        Apple d = apple.get();
        // apple 的 set 方法也可以调用
        apple.set(d);
//        Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        try {
            Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }
//        fruit.set(new Apple());
//        fruit.set(new Fruit());
        System.out.println(fruit.equals(d));
    }
}
