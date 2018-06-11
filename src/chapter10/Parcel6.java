package chapter10;

/**
 * Created by shadowwingz on 2018/6/11 0011.
 *
 * 在任意的作用域内嵌入一个内部类，
 * 这里是在 if 语句中嵌入内部类
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {

                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }

            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        /**
         * 这里无法访问到 TrackingSlip 类，
         * 因为 TrackingSlip 类是在 if 语句作用域之内，
         * 而这里是 if 语句作用域之外。
         */
//        TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
