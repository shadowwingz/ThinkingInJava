package chapter9;

/**
 * Created by shadowwingz on 2018/6/10 0010.
 */
interface Service {
    void method1();
    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    Implementation1() {

    }

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }
}

class Implementation1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {

    Implementation2() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}

class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        /**
         * getService 生成 Service 接口具体的实现，
         * 我们传入 ServiceFactory 接口不同的实现，
         * getService 方法就会生成 Service 接口不同的实现。
         */
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}

/*
输出：

Implementation1 method1
Implementation1 method2

 */
