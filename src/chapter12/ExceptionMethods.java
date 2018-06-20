package chapter12;

/**
 * Created by shadowwingz on 2018-06-20 21:00
 *
 * Exception 的一些方法
 */
public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
            System.out.println("toString(): " + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}

/*
输出：

Caught Exception
getMessage(): My Exception
getLocalizedMessage(): My Exception
toString(): java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
	at chapter12.ExceptionMethods.main(ExceptionMethods.java:9)

 */