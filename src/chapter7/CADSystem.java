package chapter7;

/**
 * Created by shadowwingz on 2018/5/9 0009.
 *
 * 调用构造器时，从基类开始调用，扩散到子类
 * 调用清理方法时，从子类开始调用，扩散到基类
 */
class Shape {
    public Shape(int i) {
        System.out.println("Shape constructor");
    }

    void dispose() {
        System.out.println("Shape dispose");
    }
}

class Circle extends Shape {
    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }

    @Override
    void dispose() {
        System.out.println("Erasing Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    public Triangle(int i) {
        super(i);
        System.out.println("Drawing Triangle");
    }

    @Override
    void dispose() {
        System.out.println("Erasing Triangle");
        super.dispose();
    }
}

class Line extends Shape {

    private int start, end;

    public Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Drawing line : " + start + ". " + end);
    }

    @Override
    void dispose() {
        System.out.println("Erasing line : " + start + ". " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("Combined constructor");
    }

    @Override
    void dispose() {
        System.out.println("CADSystem dispose");
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {

        } finally {
            x.dispose();
        }
    }
}

/*
输出：

Shape constructor
Shape constructor
Drawing line : 0. 0
Shape constructor
Drawing line : 1. 1
Shape constructor
Drawing line : 2. 4
Shape constructor
Drawing Circle
Shape constructor
Drawing Triangle
Combined constructor
CADSystem dispose
Erasing Triangle
Shape dispose
Erasing Circle
Shape dispose
Erasing line : 2. 4
Shape dispose
Erasing line : 1. 1
Shape dispose
Erasing line : 0. 0
Shape dispose
Shape dispose

 */
