package chapter15;

/**
 * Created by shadowwingz on 2018-08-12 19:37
 */
public class CountedObject {

    private static long counter = 0;

    private final long id = counter++;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}
