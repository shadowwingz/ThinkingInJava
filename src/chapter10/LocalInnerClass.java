package chapter10;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 */
interface Counter {
    int next();
}

public class LocalInnerClass {

    private int count = 0;

    /**
     * 只获取 name 的值，不需加 final，如果要修改 name，就需要加 final
     */
    Counter getCounter(String name) {
        /**
         * 在方法里定义的类，称为 局部内部类，
         * 局部内部类有带名字的构造器，构造器也可以重载
         */
        class LocalCounter implements Counter {

            /**
             * 带名字的构造器
             */
            public LocalCounter() {
                System.out.println("LocalCounter");
            }

            public LocalCounter(int i) {
                System.out.println("LocalCounter Overload");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(String name) {
        /**
         * 匿名内部类没有带名字的构造方法，
         * 只能在初始化块里初始化成员，
         * 没有带名字的构造器也意味着无法重载构造器。
         */
        return new Counter() {

            /**
             * 初始化块
             */
            {
                System.out.println("Counter");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner"),
                c2 = lic.getCounter2("Annoymous inner");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}

/*
输出：

LocalCounter
Counter
Local inner0
Local inner1
Local inner2
Local inner3
Local inner4
Annoymous inner5
Annoymous inner6
Annoymous inner7
Annoymous inner8
Annoymous inner9

 */
