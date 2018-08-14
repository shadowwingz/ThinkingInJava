package chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shadowwingz on 2018-08-14 19:50
 * <p>
 * 数组使用 [] 来访问元素
 * 列表使用 get() 来访问元素
 */
class BerylliumSphere {

    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            /**
             * BerylliumSphere 里的 counter 和 id 都是静态的，
             * 所以每创建一个 BerylliumSphere 对象，
             * BerylliumSphere 对象里的 id 值会加 1。
             */
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliumSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        /**
         * 有了泛型 Integer，容器 ArrayList 就可以指定
         * 所持有的对象必须是 Integer 类型
         * （ int 类型会自动包装为 Integer 类型）
         */
        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}

/*
输出：

[Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, null, null, null, null, null]
Sphere 4
[Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
Sphere 9
[0, 1, 2, 3, 4, 5]
4
[0, 1, 2, 3, 4, 5, 97]
4

 */