package chapter11;

import java.util.HashMap;
import java.util.Map;

import chapter14.pets.Cat;
import chapter14.pets.Dog;
import chapter14.pets.Hamster;
import chapter14.pets.Pet;

/**
 * Created by shadowwingz on 2018-06-18 15:17.
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);

        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}

/*
输出：

{My Dog=Dog Ginger, My Cat=Cat Molly, My Hamster=Hamster Bosco}
Dog Ginger
true
true

 */