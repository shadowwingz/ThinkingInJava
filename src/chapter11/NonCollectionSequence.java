package chapter11;

import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * Created by shadowwingz on 2018-06-18 22:24
 */
class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {

    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}

/*
输出：

0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx

 */
