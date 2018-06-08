package chapter9.interfaceprocessor;

import chapter9.filters.BandPass;
import chapter9.filters.Filter;
import chapter9.filters.HighPass;
import chapter9.filters.LowPass;
import chapter9.filters.Waveform;

/**
 * Created by shadowwingz on 2018/6/8 0008.
 */
class FilterAdapter implements Processor {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        /**
         * Apply.process 本来只接收 Processor 接口类型的参数，
         * LowPass，HighPass，BandPass 本来是不能传入 process 方法的，
         * 但是把 LowPass，HighPass，BandPass 丢到 FilterAdapter 中，
         * 因为 FilterAdapter 实现了 Processor 接口，
         * 所以 FilterAdapter 是可以传入 process 方法的，
         * 这样 LowPass，HighPass，BandPass 就变相传入了 process 方法，
         * 这种思想被称为 适配器设计模式。
         */
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(
                new BandPass(3.0, 4.0)), w);
    }
}
