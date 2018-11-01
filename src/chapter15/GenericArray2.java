package chapter15;

/**
 * Created by shadowwingz on 2018-10-18 0:23
 */
public class GenericArray2<T> {

    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        /**
         * 调用 get 方法的时候，对象会从 Object 转型为 T。
         */
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try {
            /**
             * 调用 rep 方法的时候，会尝试将 Object[] 转型为 T[]，
             * 这个会报异常，因为底层数组类型只能是 Object[]，不能被转型。
             */
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
输出：

0 1 2 3 4 5 6 7 8 9
java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;

 */