package chapter3;

/**
 * 输出：1 : x.c = a
 *      2 : x.c = z
 */
class Letter {
    char c;

    public Letter(char c) {
        this.c = c;
    }
}

public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter('a');
        System.out.println("1 : x.c = " + x.c);
        f(x);
        System.out.println("2 : x.c = " + x.c);
    }
}
