package chapter13;

/**
 * Created by shadowwingz on 2018-06-24 23:33
 */
public class WhitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
