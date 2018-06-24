package chapter12;

import java.io.FileInputStream;

/**
 * Created by shadowwingz on 2018-06-24 18:40
 */
public class MainException {
    /**
     * 把异常从 main 传递到控制台
     */
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream("MainException.java");
        file.close();
    }
}
