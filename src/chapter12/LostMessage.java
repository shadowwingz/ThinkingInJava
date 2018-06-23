package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 17:43
 *
 * 异常丢失
 */
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (Exception e) {
            /**
             * 只捕获到了 HoHumException 异常，
             * 没有捕获到 VeryImportantException 异常。
             */
            System.out.println(e);
        }
    }
}

/*
输出：

A trivial exception

 */