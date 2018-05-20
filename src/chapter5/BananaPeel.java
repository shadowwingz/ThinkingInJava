package chapter5;

/**
 * Created by shadowwingz on 2018/5/16 0016.
 */
class Banana {
    void peel(int i) {
        System.out.println("Banner peel " + i);
    }
}

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        a.peel(2);
    }
}
