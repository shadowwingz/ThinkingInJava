package chapter19;

/**
 * 可以覆盖枚举中的方法
 */
public enum  OverrideConstantSpecific {

    NUT, BOLT, WASHER {
        void f() {
            System.out.println("Overridden method");
        }
    };

    // NUT 和 BOLT 都没有重写 f 方法，所以会输出 default behavior
    // WASHER 重写了 f 方法，会输出 Overridden method
    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific osc : values()) {
            System.out.println(osc + ": ");
            osc.f();
        }
    }
}
