package chapter9.filters;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
public class Filter {
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
