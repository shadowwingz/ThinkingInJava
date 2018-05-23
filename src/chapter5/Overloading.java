package chapter5;

/**
 * Created by shadowwingz on 2018/5/16 0016.
 */

class Tree {
    int height;

    public Tree() {
        System.out.println("planting in seedling");
        height = 0;
    }

    public Tree(int initialheight) {
        this.height = initialheight;
        System.out.println("Creating new Tree that is " + height + " feet tall");
    }

    void info() {
        System.out.println("Tree is " + height + " feet tall");
    }

    void info(String s) {
        System.out.println(s + ": Tree is " + height + " feet tall");
    }
}

public class Overloading {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }

        // Overloaded constructor
        new Tree();
    }
}
