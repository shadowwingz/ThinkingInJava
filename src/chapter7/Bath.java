package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 *
 * 引用可以在下列位置初始化：
 * 1. 在定义对象的时候
 * 2. 在类的构造器中
 * 3. 在正要使用对象之前（惰性初始化）
 * 4. 使用实例初始化
 *
 * 静态初始化：是指执行静态初始化块里面的内容
 * 实例初始化：是指执行实例初始化块里面的内容
 */
class Soap {

    private String s;

    Soap() {
        System.out.println("Soap()");
        // 2. 在类的构造器中初始化
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {

    // 1. 在定义对象的时候初始化
    private String s1 = "Happy", s2 = "Happy", s3, s4;

    private Soap castille;

    private int i;

    private float toy;

    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // 实例初始化块
    {
        // 4. 实例初始化
        i = 47;
    }

    @Override
    public String toString() {
        // 3. 惰性初始化
        if (s4 == null) {
            s4 = "Joy";
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}

/*
输出：

Inside Bath()
Soap()
Bath{s1='Happy', s2='Happy', s3='Joy', s4='Joy', castille=Constructed, i=47, toy=3.14}

 */
