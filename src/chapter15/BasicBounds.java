package chapter15;

import java.awt.Color;

/**
 * Created by shadowwingz on 2018-11-01 23:09
 */
interface HasColor {
    Color getColor();
}

/**
 * 泛型 T 是 HasColor 的子类或实现类
 */
class Colored<T extends HasColor> {
    private T item;

    Colored(T item) {
        this.item = item;
    }

    Color color() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

//class ColorDimension<T extends HasColor & Dimension> {
//}

/**
 * 泛型 T 是 Dimension 的子类，并实现了 HasColor 接口
 */
class ColoredDimension<T extends Dimension & HasColor> {
    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

/**
 * 泛型 T 是 Dimension 的子类，并实现了 HasColor，Weight 接口
 */
class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
