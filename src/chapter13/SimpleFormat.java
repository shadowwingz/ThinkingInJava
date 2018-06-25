package chapter13;

/**
 * Created by shadowwingz on 2018-06-25 22:05
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        System.out.println("Row 1: [" + x + " " + y + "]");
        /**
         * System.out.format("Row 1: [%d %f]\n", x, y)
         *
         * 这句代码在运行的时候，
         * 会把 x 的值插入到 %d 的位置，
         * 然后将 y 的值插入到 %f 的位置。
         *
         * %d 表示 x 是一个整数，
         * %f 表示 y 是一个浮点数（float 或 double）
         */
        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
