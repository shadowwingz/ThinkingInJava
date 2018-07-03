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
        System.out.println("**** proxy : " + proxy.getClass() +
                "\n, method: " + method + "\n, args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
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
        consumer(real);
        System.out.println();
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