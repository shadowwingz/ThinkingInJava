package chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shadowwingz on 2018-07-03 20:31
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("****\nproxy : " + proxy.getClass() +
                "\nmethod: " + method + "\nargs: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        /**
         * 不管实际对象 proxied 的方法是什么（doSomething 还是 somethingElse），
         * 有没有参数（args 是否为 null），
         * 我们只需要调用 method.invoke 就可以调用实际对象的方法。
         */
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
//        consumer(real);
//        System.out.println();
        /**
         * 使用 Proxy.newProxyInstance 可以创建动态代理，newProxyInstance 的
         * 第一个参数是类加载器，
         * 第二个参数是接口列表，
         * 第三个参数是 InvocationHandler 接口的实现。
         */
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}

/*
输出：

doSomething
somethingElse bonobo

**** proxy : class chapter14.$Proxy0
, method: public abstract void chapter14.Interface.doSomething()
, args: null
doSomething
**** proxy : class chapter14.$Proxy0
, method: public abstract void chapter14.Interface.somethingElse(java.lang.String)
, args: [Ljava.lang.Object;@4b67cf4d
 bonobo
somethingElse bonobo

 */