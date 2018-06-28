package chapter14;

import java.util.HashMap;

import chapter14.pets.Cat;
import chapter14.pets.Dog;
import chapter14.pets.ForNameCreator;
import chapter14.pets.Hamster;
import chapter14.pets.Manx;
import chapter14.pets.Mouse;
import chapter14.pets.Mutt;
import chapter14.pets.Pet;
import chapter14.pets.PetCreator;
import chapter14.pets.Pug;
import chapter14.pets.Rat;
import chapter14.pets.Rodent;

/**
 * Created by shadowwingz on 2018-06-28 20:56
 */
public class PetCount {

    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName());
            /**
             * pet 是否是 Pet 类的实例
             */
            if (pet instanceof Pet)
                counter.count("Pet");
            if (pet instanceof Dog)
                counter.count("Dog");
            if (pet instanceof Mutt)
                counter.count("Mutt");
            if (pet instanceof Pug)
                counter.count("Pug");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Manx)
                counter.count("Manx");
            if (pet instanceof Manx)
                counter.count("Cymric");
            if (pet instanceof Rodent)
                counter.count("Rodent");
            if (pet instanceof Rat)
                counter.count("Rat");
            if (pet instanceof Mouse)
                counter.count("Mouse");
            if (pet instanceof Hamster)
                counter.count("Hamster");
        }
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

/*
输出：

Rat
Manx
Cymric
Mutt
Pug
Cymric
Pug
Manx
Cymric
Rat
EgyptianMau
Hamster
EgyptianMau
Mutt
Mutt
Cymric
Mouse
Pug
Mouse
Cymric

{Pug=3, Rat=2, Cymric=7, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}

 */