package chapter7;

/**
 * Created by shadowwingz on 2018/5/27 0027.
 */
// 坏人
class Villain {
    private String name;

    public Villain(String name) {
        this.name = name;
    }

    protected void set(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "I'm a Villain and my name is " + name;
    }
}

// 兽人
public class Orc extends Villain {

    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {
        /**
         * Villain 的 set 方法是 protected 修饰的，
         * 所以对其子类 Orc 是可见的
         */
        set(name);
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburget", 12);
        System.out.println(orc);
        /**
         * 调用 change 方法修改的是 orc 引用指向的对象的字段值（name 和 orcNumber），
         * 所以输出 orc 的值，值会改变
         */
        orc.change("Bob", 19);
        System.out.println(orc);
    }
}

/*
输出：

Orc 12: I'm a Villain and my name is Limburget
Orc 19: I'm a Villain and my name is Bob

 */
