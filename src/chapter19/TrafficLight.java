package chapter19;

enum Signal {
    GREEN, YELLOW, RED
}

/**
 * switch 和 enum 配合使用时，即使 case 不能覆盖所有的情况，编译期也不会报错。
 * 所以我们要确保自己覆盖了所有的情况。
 */
public class TrafficLight {

    private Signal color = Signal.RED;

    private void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "the traffic is :" + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}

/*

输出：

the traffic is :RED
the traffic is :GREEN
the traffic is :YELLOW
the traffic is :RED
the traffic is :GREEN
the traffic is :YELLOW
the traffic is :RED

 */