package chapter19;

import mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

enum Explorer {
    HERE, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("---- Analyzing " + enumClass + " -----");
        System.out.println("Interfaces:");
        // getGenericInterfaces 方法获取当前类实现的接口
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        // 获取 Explorer 类的所有方法
        Set<String> exploreMethods = analyze(Explorer.class);
        // 获取 Enum 类的所有方法
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explorer.containsAll(Enum)? "
                + exploreMethods.containsAll(enumMethods));

        System.out.println("Explorer.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        // Explorer 类比 Enum 类多出的方法
        System.out.println(exploreMethods);
    }
}
