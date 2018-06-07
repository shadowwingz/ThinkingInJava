package chapter9.filters;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
public class LowPass extends Filter {

    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
