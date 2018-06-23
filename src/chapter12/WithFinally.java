package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 15:33
 */
public class WithFinally {

    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
        } catch (OnOffException1 onOffException1) {
            onOffException1.printStackTrace();
        } catch (OnOffException2 onOffException2) {
            onOffException2.printStackTrace();
        } finally {
            /**
             * 要确保 sw.off() 方法一定会被调用，
             * 可以把 sw.off() 方法放在 finally 语句中。
             * 即使异常没有被捕获，catch 语句没有被执行，
             * finally 语句也会被执行，
             * 这样就可以确保 sw.off() 方法一定会被调用。
             */
            sw.off();
        }
    }
}

/*
输出：

on
off

 */
