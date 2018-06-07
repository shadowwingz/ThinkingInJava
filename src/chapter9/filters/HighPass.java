package chapter9.filters;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
public class HighPass extends Filter {

    double cutoff;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
