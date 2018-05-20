package chapter5;

/**
 * Created by shadowwingz on 2018/5/18 0018.
 *
 * 在垃圾回收器回收对象（System.gc()）的时候，
 * 会调用对象的 finalize 方法（继承自 Object），
 * 如果某个 Book 没有调用 checkIn 来把 checkedOut 置为 false，
 * 那么垃圾回收器回收它的时候就会打印 Error: Check Out
 */
class Book {
    boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error: Check Out");
        }
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
    }
}
