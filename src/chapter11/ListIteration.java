package chapter11;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * Created by shadowwingz on 2018/6/17 0017.
 *
 * ListIterator 只能用于各种 List 的迭代。
 * Iterator 只能向前移动：next(),
 * 但是 ListIterator 可以双向移动：previous() 和 next()
 * 它还可以获取当前位置的前一个和后一个元素的索引：previousIndex() 和 nextIndex()
 * 并且可以使用 set() 方法替换它访问过的最后一个元素。
 *
 * 还可以调用 listIterator(n) 方法创建一个
 * 一开始就指向列表索引为 n 的元素处的 ListIterator
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();

        System.out.println(pets);

        /**
         * 返回一个迭代器，这个迭代器从 pets 的第 4 个元素开始。
         */
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            /**
             * 替换列表中的元素
             */
            it.set(Pets.randomPet());
        }
        System.out.println(pets);
    }
}

/*
输出：

Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]

 */