package chapter12;

/**
 * Created by shadowwingz on 2018-06-22 23:59
 */
public class OnOffSwitch {

    private static Switch sw = new Switch();

    /**
     * f() 方法只是声明了会抛出异常，但实际上在方法里并没有抛出异常，
     * 所以调用 f() 方法所以需要 catch 异常，但是 catch 语句不会被执行
     */
    public static void f() throws OnOffException1, OnOffException2 {
//        throw new OnOffException1();
    }

    public static void main(String[] args) {
        try {
            sw.on();
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
            onOffException1.printStackTrace();
            sw.off();
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
            onOffException2.printStackTrace();
            sw.off();
        }
    }
}

/*
输出：

on
off

 */
