package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import chapter14.pets.Cymric;
import chapter14.pets.Hamster;
import chapter14.pets.Mouse;
import chapter14.pets.Pet;
import chapter14.pets.Pets;

/**
 * Created by shadowwingz on 2018/6/17 0017.
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1: " + pets);

        Hamster h = new Hamster();
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));

        pets.remove(h);
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));

        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));

        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, new Mouse());
        System.out.println("9: " + pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        /**
         * 把 sub 的第一个元素修改为 Mouse，
         * 对于 sub 的修改会反映到 pets 中，
         * 也就是说，pets 中对应的元素也会被修改为 Mouse。
         */
        sub.set(0, new Mouse());
        System.out.println("subList: " + sub);
        System.out.println("list: " + pets);
        System.out.println("10: " + pets.containsAll(sub));

        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);

        /**
         * 对于 containsAll 方法而言，子列表的元素顺序并不重要
         */
        System.out.println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand);
        System.out.println("shuffled subList: " + sub);
        /**
         * sub 的元素顺序被打乱了，但是 pets.containsAll(sub) 还是返回 true
         */
        System.out.println("12: " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);

        copy = new ArrayList<>(pets);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);

        copy.set(1, new Mouse());
        System.out.println("16: " + copy);

        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());

        pets.clear();
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());

        pets.addAll(Pets.arrayList(4));
        System.out.println("21: " + pets);

        /**
         * 直接调用 List 的 toArray 方法，返回的是 Object 数组
         */
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);

        /**
         * 调用 List 的 toArray 方法，传入 Pet 类型的数组，
         * 返回的是 Pet 类型的数组，pets 列表中的元素被存储到 pa 数组中
         */
        Pet[] pa = pets.toArray(new Pet[0]);

        System.out.println("23: " + pa[3].id());
    }
}

/*
输出：

1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
subList: [Mouse, Mutt, Mouse]
list: [Rat, Mouse, Mutt, Mouse, Pug, Cymric, Pug]
10: true
sorted subList: [Mouse, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Mouse, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 15

 */