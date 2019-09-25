package chapter19;

import mindview.util.Enums;

public enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            /**
             * Enums.random(SecurityCategory.class) 会返回 SecurityCategory 的对象，
             * 这个对象可能是 STOCK，也可能是 BOND。
             */
            SecurityCategory category = Enums.random(SecurityCategory.class);
            /**
             * category.randomSelection() 会返回 Stock 或 Bond 的值，
             * 可能是 SHORT, LONG, MARGIN, MUNICIPAL, JUNK
             */
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}

/*

输出：

BOND: MUNICIPAL
BOND: MUNICIPAL
STOCK: MARGIN
STOCK: MARGIN
BOND: JUNK
STOCK: SHORT
STOCK: LONG
STOCK: LONG
BOND: MUNICIPAL
BOND: JUNK

 */