package chapter15;

/**
 * Created by shadowwingz on 2018-10-03 23:52
 */
public class SimpleHolder {

    private Object obj;

    public Object get() {
        return obj;
    }

    public void set(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }
}
