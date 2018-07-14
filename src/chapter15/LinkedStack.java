package chapter15;

/**
 * Created by shadowwingz on 2018-07-14 23:24
 */
public class LinkedStack<T> {

    /**
     * Node 是一个泛型
     */
    private static class Node<U> {

        U item;

        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    /**
     * 每调用一次 push 方法，就会创建一个 Node 对象，
     * 并将其链接到前一个 Node 对象。
     */
    public void push(T item) {
        /**
         * LinkedStack 默认只有一个 Node 对象 top（null），
         * 调用一次 push，top 会作为新的 Node 对象的 next，
         * 同时 top 会被赋值为新的 Node 对象，
         * 再调用一次 push，top 会作为新的 Node 对象的 next，
         * 同时 top 会被赋值为新的 Node 对象，
         * ......
         */
        top = new Node<>(item, top);
    }

    /**
     * 调用 pop 时，会返回 top.item，
     * 然后 top 再指向下一个 top。
     */
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}

/*
输出：

stun!
on
Phasers

 */