package chapter19.menu;

import mindview.util.Enums;

public enum Course {

    APPETIZER(Food.Appetizer.class),
    MainCourse(Food.MainCourse.class),
    Dessert(Food.Dessert.class),
    Coffee(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
