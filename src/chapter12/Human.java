package chapter12;

/**
 * Created by shadowwingz on 2018-06-24 12:30
 */
class Annoyance extends Exception {

}

class Sneeze extends Annoyance {

}

public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            /**
             * 把这个 catch 语句删除，程序也可以正常运行，输出：
             *
             * Caught Annoyance
             * Caught Annoyance
             *
             * 说明抛出的子类异常，可以被处理父类异常的 catch 语句捕获，
             * 也就是说，catch (Annoyance e) 会捕获 Annoyance 及其子类类型的异常
             */
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            /**
             * 如果把 catch (Annoyance a) 放在 catch (Sneeze s) 的前面，
             * 那么 Annoyance 及其子类类型的异常都会被 catch (Annoyance a) 捕获，
             * 那么 catch (Sneeze s) 就永远也不会执行了。
             * 这时程序会报错。
             */
            System.out.println("Caught Annoyance");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}

/*
输出：

Caught Sneeze
Caught Annoyance

 */