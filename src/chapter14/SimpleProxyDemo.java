package chapter14;

/**
 * Created by shadowwingz on 2018-07-02 23:07
 */
interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

/**
 * 实际对象
 */
class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

/**
 * 动态代理
 */
class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    /**
     * 在静态代理中，我们要调用实际对象的 doSomething 方法，
     * 我们需要自己定义一个 doSomething 方法。
     * 而在动态代理中，我们只需要调用 method.invoke 方法就可以了，
     * 不管实际对象的方法名是什么，我们都可以调用。
     */
    @Override
    public void doSomething() {
        // 代理先做些自己的事
        System.out.println("SimpleProxy doSomething");
        // 再调用实际对象的方法
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
//        consumer(new RealObject());
//        System.out.println();
        consumer(new SimpleProxy(new RealObject()));
    }
}

/*
输出：

doSomething
somethingElse bonobo

SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo

 */
