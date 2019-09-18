package chapter17;

import mindview.util.CollectionData;
import mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDataGeneration {
    public static void main(String[] args) {
        /**
         * CollectionData.list(new RandomGenerator.String(9), 10))
         * 会生成 10 个长度为 9 的随机字符串
         */
        System.out.println(new ArrayList<String>(
                CollectionData.list(new RandomGenerator.String(9), 10)));
        /**
         * new CollectionData<>(new RandomGenerator.Integer(), 10))
         * 会生成 10 个 int 数字。
         */
        System.out.println(new HashSet<Integer>(
                new CollectionData<>(new RandomGenerator.Integer(), 10)));
    }
}

/*

输出：

[YNzbrnyGc, FOWZnTcQr, GseGZMmJM, RoEsuEcUO, neOEdLsmw, HLGEahKcx, rEqUCBbkI, naMesbtWH, kjUrUkZPg, wsqPzDyCy]
[2017, 8037, 871, 7882, 6090, 4779, 299, 573, 4367, 3455]

 */