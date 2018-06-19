package chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by shadowwingz on 2018-06-19 22:54
 *
 * 使用 java.util.logging 工具将输出记录到日志中
 */
class LoggingException extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

/*
输出：

六月 19, 2018 11:01:08 下午 chapter12.LoggingException <init>
严重: chapter12.LoggingException
	at chapter12.LoggingExceptions.main(LoggingExceptions.java:24)

Caught chapter12.LoggingException
六月 19, 2018 11:01:08 下午 chapter12.LoggingException <init>
严重: chapter12.LoggingException
	at chapter12.LoggingExceptions.main(LoggingExceptions.java:29)

Caught chapter12.LoggingException

 */