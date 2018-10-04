package chapter15;

/**
 * Created by shadowwingz on 2018-10-04 0:30
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            /**
             * newInstance 方法会调用类的默认构造器，
             * 如果类没有默认构造器，就会抛异常。
             */
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        // Employee 类没有显式声明构造器，但它有一个默认的无参构造器
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            // Integer 没有默认的构造器
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}

/*
输出：

ClassAsFactory<Employee> succeeded
ClassAsFactory<Integer> failed

 */