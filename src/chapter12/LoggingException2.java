package chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by shadowwingz on 2018-06-19 23:05
 */
public class LoggingException2 {

    private static Logger logger = Logger.getLogger("LoggingException2");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            /**
             * 不使用系统自带的 e.printStackTrace()，
             * 使用我们自己定义的 logException 方法来生成日志消息
             */
            logException(e);
        }
    }
}

/*
输出：

六月 19, 2018 11:06:44 下午 chapter12.LoggingException2 logException
严重: java.lang.NullPointerException
	at chapter12.LoggingException2.main(LoggingException2.java:22)

 */
