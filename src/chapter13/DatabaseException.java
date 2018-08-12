package chapter13;

/**
 * Created by shadowwingz on 2018-06-25 22:38
 *
 * String.format 用法
 */
public class DatabaseException extends Exception {

    public DatabaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
输出：

chapter13.DatabaseException: (t3, q7) Write failed

 */