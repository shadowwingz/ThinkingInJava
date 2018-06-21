package chapter12;

/**
 * Created by shadowwingz on 2018-06-21 22:27
 *
 * 无论异常是否被抛出，finally 总能被执行。
 *
 * 把 try catch 语句放在循环里，可以尝试一定的次数来修复异常，增加程序的健壮性。
 */
class ThreeException extends Exception {
}

public class FinallyWorks {

    static int count = 0;

    public static void main(String[] args) {
        /**
         * while 语句会一直执行
         *
         * 先判断 count++ 是否等于 0，结果是等于 0
         * （这里等于 0 是因为 count 是在和 0 比较之后才加 1 的）
         * 所以抛出异常，抛出异常之后，就不会执行下面的输出 No exception 的语句了，
         * 会执行到 catch 语句，在 catch 语句中会打印出异常：
         *
         * chapter12.ThreeException
         *      at chapter12.FinallyWorks.main
         *
         * catch 语句执行完后，会进入 finally 语句，接着输出：
         *
         * In finally clause
         *
         * 然后判断 count 是否等于 2，结果是不等于（此时 count = 1），
         * 所以 while 循环，再次判断 count++ 是否等于 0，结果是不等于
         * （此时 count = 1，和 0 比较完之后，count 就等于 2 了）
         * 所以输出：
         *
         * No exception
         *
         * 因为没有抛出 ThreeException 异常，所以不会进入 catch 语句，所以就直接进入 finally 语句了，
         * 输出：
         *
         * In finally clause
         *
         * 接着比较 count是否等于 2，结果是等于。所以 break 退出循环。
         */
        while (true) {
            try {
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                e.printStackTrace();
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

/*
输出：

chapter12.ThreeException
	at chapter12.FinallyWorks.main(FinallyWorks.java:50)
In finally clause
No exception
In finally clause

 */