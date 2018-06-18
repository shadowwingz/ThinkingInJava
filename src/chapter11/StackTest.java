package chapter11;

import java.util.Stack;

/**
 * Created by shadowwingz on 2018/6/18 0018.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

/*
输出：

fleas has dog My

 */
