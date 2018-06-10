package chapter10;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 * <p>
 * sequence 序列
 */
interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence {

    private Object[] items;

    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    /**
     * 可以看到，SequenceSelector 中可以访问外部类 Sequence
     * 的 private 字段 items，不仅是字段，内部类自动拥有对其外部类所有成员的访问权。
     *
     */
    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            /**
             * 通过 Sequence.class 可以知道，这里引用 items 实际上
             * 是通过 Sequence.this.items 引用的，也就是说，
             * 内部类会持有外部类的一个引用，通过这个引用，
             * 内部类可以访问外部类的所有成员（字段和方法），
             * 即使成员是 private 的。
             */
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

/*
输出：

0 1 2 3 4 5 6 7 8 9

 */
