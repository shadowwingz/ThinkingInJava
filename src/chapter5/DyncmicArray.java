package chapter5;

/**
 * Created by shadowwingz on 2018/5/21 0021.
 */
public class DyncmicArray {
    public static void main(String[] args) {
        Other.main(new String[]{"fiddle", "de", "dum"});
    }
}

class Other {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
    }
}

/*
输出：

fiddle de dum

 */