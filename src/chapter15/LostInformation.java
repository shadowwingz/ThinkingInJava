package chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shadowwingz on 2018-08-19 17:12
 * <p>
 * List<Frob> list = new ArrayList<>()
 * getTypeParameters 方法并不是返回 Frob，
 * 而是返回用作参数占位符的标识符 [E]
 */
class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}

public class LostInformation {
    public static void main(String[] args) {
        /**
         * public interface List<E> extends Collection<E>
         */
        List<Frob> list = new ArrayList<>();
        /**
         * 输出：[E]
         */
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

        /**
         * public interface Map<K,V>
         */
        Map<Frob, Fnorkle> map = new HashMap<>();
        /**
         * 输出：[K, V]
         */
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        /**
         * class Quark<Q>
         */
        Quark<Fnorkle> quark = new Quark<>();
        /**
         * 输出：[Q]
         */
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));

        /**
         * class Particle<POSITION, MOMENTUM>
         */
        Particle<Long, Double> p = new Particle<>();
        /**
         * 输出：[POSITION, MOMENTUM]
         */
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}

/*
输出：

[E]
[K, V]
[Q]
[POSITION, MOMENTUM]

 */