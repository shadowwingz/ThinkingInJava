package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 23:30
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            /**
             * 这句代码如果执行失败，会进入 1 处的 catch 语句，
             * 2 处的 dispose 方法不会被调用。
             *
             * 如果执行失败，那么说明 InputFile 对象没有创建成功，
             * 那也不需要清理 in.dispose()。
             */
            InputFile in = new InputFile("Cleanupl.Java");
            /**
             * 如果能执行到这里，说明上面的代码执行成功，InputFile 对象创建成功，
             * 那么为了确保 InputFile 对象能够被清理，可以立即创建一个 try catch 语句，
             * 在 finally 语句中清理 InputFile 对象，这样无论发生了什么异常，
             * InputFile 对象都会被清理。
             */
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ;
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                // 2
                in.dispose();
            }
        } catch (Exception e) { // 1
            System.out.println("InputFile construction failed");
        }
    }
}

/*
输出：

Could not open Cleanupl.Java
InputFile construction failed

 */