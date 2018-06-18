package chapter11;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;

/**
 * Created by shadowwingz on 2018/6/18 0018.
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        System.out.println(pets);

        /**
         * getFirst()，element()，peek() 都返回列表的第一个元素
         *
         * 当列表为空（null）时，
         * getFirst()，element() 会抛异常，
         * peek() 会返回 null
         */
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());
        System.out.println("pets.peek(): " + pets.peek());

        /**
         * remove()，removeFirst()，poll() 都移除并返回列表的第一个元素
         *
         * 当列表为空（null）时，
         * remove()，removeFirst() 会抛异常，
         * poll() 会返回 null
         */
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        System.out.println("pets.poll()" + pets.poll());
        System.out.println(pets);

        /**
         * addFirst()，add() 都是将元素添加到列表的头部
         */
        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);

        /**
         * offer(),addLast() 都是将元素添加到列表的尾部
         */
        pets.offer(Pets.randomPet());
        System.out.println("After offer(): " + pets);

        pets.add(Pets.randomPet());
        System.out.println("After add(): " + pets);

        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);

        /**
         * removeLast() 会移除并返回列表的最后一个元素
         */
        System.out.println("pets.removeLast(): " + pets.removeLast());
    }
}
