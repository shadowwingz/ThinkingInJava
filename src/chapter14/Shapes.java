package chapter14;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shadowwingz on 2018-06-26 21:05
 */
abstract class Shape {

    void draw() {
        /**
         * 在字符串表达式中调用 this，会调用 this.toString() 方法
         */
        System.out.println(this + ".draw()");
    }

    /**
     * toString 方法被声明为 abstract，强制子类重写此方法
     */
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
        }
    }
}

/*
输出：

Circle.draw()
Square.draw()
Triangle.draw()

 */