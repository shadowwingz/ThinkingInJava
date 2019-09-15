package chapter16;

import java.util.Arrays;

/**
 * 粗糙数组也可以用于非基本类型的对象数组
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                },
                {
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere()
                },
                {
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                        new BerylliumSphere(),
                }
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}

/*

输出：

[
    [Sphere 0, Sphere 1],
    [Sphere 2, Sphere 3, Sphere 4, Sphere 5],
    [Sphere 6, Sphere 7, Sphere 8, Sphere 9, Sphere 10, Sphere 11, Sphere 12]
]

 */