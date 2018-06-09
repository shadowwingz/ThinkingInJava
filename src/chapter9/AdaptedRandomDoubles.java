package chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * Created by shadowwingz on 2018/6/9 0009.
 *
 * RandomDoubles 没有实现 Readable 接口，因此不能传入 Scanner 类中，
 * 那么怎么才能让 Scanner 作用于 RandomDoubles 呢？
 * 使用适配器模式，新建一个类 AdaptedRandomDoubles，
 * 继承自 RandomDoubles，然后实现 Readable 接口，
 * 在 read 方法中调用 RandomDoubles 的 next 方法。这样就可以了。
 * AdaptedRandomDoubles 既是 RandomDoubles 又是 Readable。
 *
 * 这里也可以体现出接口的灵活性，如果 Scanner 要求传入一个具体类 A，
 * 那就我们只能传入 A 和 A 的子类，假如我们已经有了一个现成的类 B ，
 * 这个 B 类又继承了别的类，由于 Java 中只能继承（extends）一个类，所以 B 类无法再继承 A 类，
 * 这样 B 类就无法传入 Scanner 类了。
 *
 * 如果 Scanner 要求传入一个接口。
 * 那么我们只需让现成的类 B 实现（implements） 接口即可，
 * Java 中可以 implements 多个接口。
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }

        String result = Double.toString(next()) + "\n";
        cb.append(result);

        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble()) {
            System.out.println(s.nextDouble());
        }
    }
}

/*
输出：

0.7271157860730044
0.5309454508634242
0.16020656493302599
0.18847866977771732
0.5166020801268457
0.2678662084200585
0.2613610344283964

 */