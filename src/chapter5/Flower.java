package chapter5;

/**
 * Created by shadowwingz on 2018/5/17 0017.
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    public Flower(int petalCount) {
        this.petalCount = petalCount;
        System.out.println("Constructor w/ int arg only, petalCount = " + petalCount);
    }

    public Flower(String s) {
        this.s = s;
        System.out.println("Constructor w/ String arg only, s = " + s);
    }

    public Flower(String s, int petalCount) {
        this(petalCount);
        this.petalCount = petalCount;
        this.s = s;
    }

    public Flower() {
        this("hi", 47);
    }

    void printPetalCount() {
//        this(11);
    }
}
