package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by shadowwingz on 2018-06-18 14:58.
 * <p>
 * statistics 统计
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            /**
             * int 不能作为键值，这里把 int 包装成了 Integer。
             */
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}

/*
输出：

{0=481, 1=502, 2=489, 3=508, 4=481, 5=503, 6=519, 7=471, 8=468, 9=549,
10=513, 11=531, 12=521, 13=506, 14=477, 15=497, 16=533, 17=509, 18=478, 19=464}

 */