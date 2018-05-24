package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 * <p>
 * 组合语法，就是在一个类中创建另一个类的对象
 */
class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class SprinklerSystem {

    /**
     * 类的成员会被自动初始化
     * String 类型的对象会被初始化为 null
     * int 类型的对象会被初始化为 0
     * float 类型的对象会被初始化为 0.0
     */
    private String value1, value2, value3, value4;

    private WaterSource source = new WaterSource();

    private int i;

    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinkler = new SprinklerSystem();
        /**
         * 这句代码会调用 sprinkler 的 toString() 方法，
         */
        System.out.println(sprinkler);
    }
}

/*
输出：

WaterSource()
SprinklerSystem{value1='null', value2='null', value3='null',
value4='null', source=Constructed, i=0, f=0.0}

 */
