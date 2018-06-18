package chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.Mutt;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;

/**
 * Created by shadowwingz on 2018-06-18 15:24.
 */
public class MapOfList {

    public static Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    static {
        /**
         * Map 的键是 Person 对象，值是 List<Pet>
         */
        petPeople.put(new Person("Dawm"),
                Arrays.asList(
                        new Cymric("Molly"),
                        new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(
                        new Cat("Shackleton"),
                        new Cat("Elsie May"),
                        new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"),
                Arrays.asList(
                        new Pug("Louie aka louis Snorkelstein Dupree"),
                        new Cat("Stanford aka Stinky el Negro"),
                        new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
                Arrays.asList(
                        new Rat("Fuzzy"),
                        new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
                Arrays.asList(
                        new Rat("Freckly")));
    }

    public static void main(String[] args) {
        /**
         * keySet() 会返回在 petPeople 中所有的键组成的 Set
         */
        System.out.println("People: " + petPeople.keySet());
        /**
         * values() 会返回 Map 中所有的值
         */
        System.out.println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.print(person + " has:");
            for (Pet pet : petPeople.get(person)) {
                System.out.print("    " + pet);
            }
            System.out.println();
        }
    }
}

/*
输出：

People: [Person Marilyn, Person Luke, Person Dawm, Person Isaac, Person Kate]
Pets:
[[Pug Louie aka louis Snorkelstein Dupree, Cat Stanford aka Stinky el Negro, Cat Pinkola],
 [Rat Fuzzy, Rat Fizzy],
 [Cymric Molly, Mutt Spot],
 [Rat Freckly],
 [Cat Shackleton, Cat Elsie May, Dog Margrett]]
Person Marilyn has:    Pug Louie aka louis Snorkelstein Dupree    Cat Stanford aka Stinky el Negro    Cat Pinkola
Person Luke has:    Rat Fuzzy    Rat Fizzy
Person Dawm has:    Cymric Molly    Mutt Spot
Person Isaac has:    Rat Freckly
Person Kate has:    Cat Shackleton    Cat Elsie May    Dog Margrett

 */
