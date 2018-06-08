package chapter9.interfaceprocessor;

import java.util.Arrays;

/**
 * Created by shadowwingz on 2018/6/8 0008.
 *
 * StringProcessor 类实现了 Processor 接口，但是只实现了 name 方法，
 * 没有实现 process 方法，如果别的类（不是抽象类）继承自 StringProcessor，
 * 那么这个类就必须要实现 process 方法。
 */
public abstract class StringProcessor implements Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static String s =
            "If She weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new DownCase(), s);
        Apply.process(new Splitter(), s);
    }
}

class Upcase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

/*
输出：

Using Processor Upcase
IF SHE WEIGHS THE SAME AS A DUCK, SHE'S MADE OF WOOD
Using Processor DownCase
if she weighs the same as a duck, she's made of wood
Using Processor Splitter
[If, She, weighs, the, same, as, a, duck,, she's, made, of, wood]

 */
