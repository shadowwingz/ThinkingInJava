package chapter15;

import chapter14.Person;
import chapter14.pets.Pet;
import mindview.util.New;

import java.util.List;
import java.util.Map;

/**
 * created by shadowwingz on 2020-02-03 21:34
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {

    }

    public static void main(String[] args) {
        /**
         * 显式的类型说明
         * 一般我们是调用 New.map()
         * 显式调用，就是 New.<Person, List<Pet>>map()
         * 这种语法很少使用
         */
        f(New.<Person, List<Pet>>map());
    }
}
