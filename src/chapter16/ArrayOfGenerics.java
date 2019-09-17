package chapter16;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = la;
        ls[0] = new ArrayList<>();

        // 编译期会报错
//        ls[1] = new ArrayList<Integer>();

        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();

        List<BerylliumSphere>[] spheres = new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<>();
        }
    }
}
