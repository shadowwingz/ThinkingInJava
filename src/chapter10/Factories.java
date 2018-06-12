package chapter10;

/**
 * Created by shadowwingz on 2018/6/12 0012.
 * <p>
 * 匿名内部类和工厂方法
 */
interface Service {

    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {

    /**
     * 构造器用 private 修饰，所以在别的类中
     * 无法使用 new Implementation1 来创建 Implementation1 实例，
     * 只能调用 Implementation1.factory 获取 ServiceFactory 的实例，
     * 获取的实例是 ServiceFactory 的匿名内部类。
     */
    private Implementation1() {

    }

    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    private Implementation2() {

    }

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

public class Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}

/*
输出：

Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2

 */
