package chapter9.filters;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
public class BandPass extends Filter {

    double lowCutoff, highCutoff;

    public BandPass(double lowCut, double highCut) {
        lowCutoff = lowCut;
        highCutoff = highCut;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
