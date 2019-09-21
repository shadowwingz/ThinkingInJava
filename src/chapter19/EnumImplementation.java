package chapter19;

import chapter14.pets.Pet;
import mindview.util.Generator;

import java.util.Random;

// enum 对象无法继承其他类
//enum NotPossible extends Pet {
//
//}

// 但是 enum 对象可以实现接口
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.println(rg.next() + ", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

/*

输出：

BOB,
PUNCHY,
BOB,
SPANKY,
NUTTY,
PUNCHY,
SLAPPY,
NUTTY,
NUTTY,
SLAPPY,

 */