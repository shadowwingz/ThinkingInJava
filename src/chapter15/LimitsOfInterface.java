package chapter15;

import java.util.List;
import java.util.Map;

import chapter14.Person;
import chapter14.pets.Pet;
import mindview.util.New;

/**
 * Created by shadowwingz on 2018-08-12 18:08
 */
public class LimitsOfInterface {
    static void f(Map<Person, List<? extends Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.map());
    }
}
