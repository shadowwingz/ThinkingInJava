package chapter14;

/**
 * Created by shadowwingz on 2018-06-26 21:38
 */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            /**
             * 如果类 Gum 还没有被加载就加载它
             */
            Class.forName("chapter14.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName('Gum')");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}

/*
输出：

inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName('Gum')
Loading Cookie
After creating Cookie

 */
