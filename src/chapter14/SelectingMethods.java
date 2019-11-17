package chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by shadowwingz on 2018-07-03 21:10
 *
 * 使用动态代理的好处是，我们不用再关心实际对象有哪些方法了，不用再针对实际对象的每个方法写一个代理方法，
 * 直接 method.invoke 就行了，虽然方便很多，但是也带来了一个弊端，如果我们确实想针对某个方法做对应处理，
 * 比如在本例中，如果调用 interesting 方法，我们会打印一条 log。
 * 那么我们就要对方法名进行过滤。如果是 interesting 方法，就打印一条 log。
 */
// MethodSelector 实现了 InvocationHandler 接口，所以它是个代理类
class MethodSelector implements InvocationHandler {

    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 如果调用的是 interesting 方法，就打印 log
        if (method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {

    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

/**
 * 接口具体的实现，代理类 MethodSelector 中，会调用这个对象的方法。
 */
class Implementation implements SomeMethods {

    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting " + arg);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation()));
        proxy.boring1();
        proxy.boring2();
        proxy.interesting("bonobo");
        proxy.boring3();
    }
}

/*
输出：

boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3

 */