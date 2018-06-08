package chapter9.interfaceprocessor;

/**
 * Created by shadowwingz on 2018/6/8 0008.
 */
public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
