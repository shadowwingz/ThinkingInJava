package chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by shadowwingz on 2018-06-30 23:54
 *
 * 类方法提取器
 *
 * 运行这个类时，要在 ThinkingInJava 目录下调用
 *
 * java chapter14.ShowMethods chapter14.ShowMethods
 */
public class ShowMethods {

    private static String usage =
            "Usage:\n " +
                    "ShowMethods qualified.class.name\n" +
                    " To show all methods in class or:\n" +
                    " ShowMethods qualified.class.name word\n" +
                    " To search for methods involving 'word';";

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            /**
             * 使用 Class.forName 加载一个类
             */
            Class<?> c = Class.forName(args[0]);
            /**
             * 使用 getMethods 方法获取类的方法
             */
            Method[] methods = c.getMethods();
            /**
             * 使用 getConstructors 获取类的构造器
             */
            Constructor<?>[] ctors = c.getConstructors();
            if (args.length == 1) {
                System.out.println("方法");
                for (Method method : methods) {
                    /**
                     * 打印方法的名字
                     */
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                System.out.println();
                System.out.println("构造器");
                for (Constructor<?> ctor : ctors) {
                    /**
                     * 打印构造器的方法
                     */
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor<?> ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}

/*
输出：

方法
public static void main(String[])
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()

构造器
public ShowMethods()

 */