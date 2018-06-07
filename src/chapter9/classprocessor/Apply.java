package chapter9.classprocessor;

import java.util.Arrays;

/**
 * Created by shadowwingz on 2018/6/7 0007.
 */
class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Apply {
    /**
     * 在 Apply 的 process 方法中，
     * 调用了 Processor 对象的 name 方法和 process 方法，
     * 而 {@link chapter9.filters.Filter} 类中也有这两个方法，
     * 按理说可以把 Filter 对象传入 Apply 的 process 方法，但是不行，
     * 因为 Apply 的 process 方法只接收 Processor 和它的子类作为参数，
     * 别的类即使有相同的方法，也无法接收，这就限制的比较死，俗称，耦合过紧。
     */
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s =
            "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}

/*
输出：

Using Processor Upcase
DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
Using Processor Downcase
disagreement with beliefs is by definition incorrect
Using Processor Splitter
[Disagreement, with, beliefs, is, by, definition, incorrect]

 */
