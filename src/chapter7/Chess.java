package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 *
 * 如果基类没有默认的构造器，
 * 或者我们想调用一个带参数的基类构造器，
 * 就必须用 super 显式调用基类构造器
 */
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    // 这里的 BoardGame 类的构造器可以是无参数的
    BoardGame(int i) {
        /**
         * 基类 Game 的构造器是带参数的，
         * 所以必须调用 super(i) 来显式调用 Game 类的构造器，
         * 而且，super(i) 必须是第一句代码
         */
        super(i);
        System.out.println("BoardGame constructor");
        // super(i) 只能放在第一句，放在别的位置会报错
//        super(i);
    }
}

public class Chess extends BoardGame {
    Chess() {
        /**
         * 基类 BoardGame 的构造器是带参数的，
         * 所以必须调用 super(11) 来显式调用 BoardGame 类的构造器
         */
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}

/*
输出：

Game constructor
BoardGame constructor
Chess constructor

 */
