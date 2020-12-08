package chapter20;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
    private static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        // 获取 Class 中所有的方法
        for (Method m : cl.getDeclaredMethods()) {
            // 获取每一个方法的注解
            // 如果方法有 UseCase 的注解，就返回 UseCase 类型的注解，
            // 否则返回 null
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                // 打印注解中的 id 和 description
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer i : useCases) {
            System.out.println("Warning: Missing use case " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
