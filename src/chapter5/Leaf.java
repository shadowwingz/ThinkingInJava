package chapter5;

/**
 * Created by shadowwingz on 2018/5/17 0017.
 */
public class Leaf {
    int i = 0;
    Leaf incrment() {
        i++;
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.incrment().incrment().incrment().print();
    }
}
