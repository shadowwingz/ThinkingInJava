package chapter13;

import java.util.Scanner;

/**
 * Created by shadowwingz on 2018-06-25 23:40
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name?");
        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you? What is your favorite double?");
        System.out.println("(input: <age> <double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.format("Hi %s .\n", name);
        System.out.format("In 5 years you will be %d.\n", age + 5);
        System.out.format("My favorite double is %f.", favorite / 2);
    }
}

/*
输出：

What is your name?
Sir Robin of Camelot
How old are you? What is your favorite double?
(input: <age> <double>)
Hi Sir Robin of Camelot .
In 5 years you will be 27.
My favorite double is 0.809015.

 */