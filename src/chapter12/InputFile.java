package chapter12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by shadowwingz on 2018-06-23 23:09
 */
public class InputFile {

    private BufferedReader in;

    public InputFile(String fname) throws Exception {
        try {
            /**
             * 如果这句代码失败了，将抛出 FileNotFoundException 异常。
             */
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            /**
             * 如果捕获到 FileNotFoundException 异常，说明文件打开失败，
             * 也就是还没打开，这种情况下不需要关闭文件 in.close()
             */
            System.out.println("Could not open " + fname);
            throw e;
        } catch (Exception e) {
            /**
             * 如果进入到这个 catch 语句，说明没有捕获到
             * FileNotFoundException 异常，而是捕获到了其他的异常，
             * 说明文件打开成功，但是有其他的异常，这种情况下应该关闭文件。
             */
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            /**
             * 因为我们希望文件在 InputFile 对象的整个生命周期内
             * 都处于打开状态，而不是在构造器里一打开就关闭，
             * 所以不要在 finally 中关闭文件。如果在 finally 中关闭文件，
             * 那么构造器一执行完，文件就关闭了。
             */
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
