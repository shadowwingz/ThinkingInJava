package chapter9.filters;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
public class Waveform {

    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
