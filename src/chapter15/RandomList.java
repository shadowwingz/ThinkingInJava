package chapter15;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shadowwingz on 2018-07-23 21:41
 */
public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();

    private Random rand = new Random(47);

    /**
     * 存储的时候是按照顺序存储的
     */
    public void add(T item) {
        storage.add(item);
    }

    /**
     * 取出的时候是随机取出的
     */
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : "The quick brown fox jumped over the lazy brown dog".split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
    }
}

/*
输出：

brown over fox quick quick dog brown The brown lazy brown

 */