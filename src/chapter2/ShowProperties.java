package chapter2;

/**
 * Created by shadowwingz on 2018/5/14 0014.
 */
public class ShowProperties {

    /**
     *
     * you can <em>even</em> insert in list:
     *
     * <ol>
     *
     *    <li>Iten one</li>
     *    <li>Item two</li>
     *    <li>Item three</li>
     * </ol>
     *
     * @see ShowProperties#test()
     * @see ShowProperties
     *
     * @param args
     *
     * @deprecated
     */
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        test();
    }

    @Deprecated
    public static void test() {

    }
}
