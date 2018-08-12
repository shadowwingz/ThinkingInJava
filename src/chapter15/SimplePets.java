package chapter15;

import java.util.List;
import java.util.Map;

import chapter14.Person;
import chapter14.pets.Pet;
import mindview.util.New;

/**
 * Created by shadowwingz on 2018-08-12 17:54
 */
public class SimplePets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> perPeople = New.map();
    }
}
