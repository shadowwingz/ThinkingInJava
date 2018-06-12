package chapter10;

/**
 * Created by shadowwingz on 2018/6/12 0012.
 */
interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checker implements Game {

    private Checker() {

    }

    private int moves = 0;

    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checker();
        }
    };
}

class Chess implements Game {

    private Chess() {

    }

    private int moves = 0;

    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}

public class Games {

    public static void playGame(GameFactory factory) {
        Game s = factory.getGame();
        while (s.move())
            ;
    }

    public static void main(String[] args) {
        playGame(Checker.factory);
        playGame(Chess.factory);
    }
}

/*
输出：

Checkers move 0
Checkers move 1
Checkers move 2
Chess move 0
Chess move 1
Chess move 2
Chess move 3

 */
