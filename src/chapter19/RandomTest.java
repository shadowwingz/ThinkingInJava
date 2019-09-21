package chapter19;

import mindview.util.Enums;

enum Activity {
    A, B, C, D
}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Enums.random(Activity.class));
        }
    }
}

/*

输出：

C
B
C
A
A

 */