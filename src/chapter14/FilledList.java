package chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shadowwingz on 2018-06-27 22:22
 */
class CountedInteger {

    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        try {
            for (int i = 0; i < nElements; i++) {
                /**
                 * type.newInstance() 方法执行成功的前提
                 * 是 CountedInteger 有默认的构造器（无参构造器）
                 */
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}

/*
输出：

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]

 */