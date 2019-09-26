package chapter19;

import java.util.EnumSet;

public class CarWash {

    public enum Cycle {
        UNDERBODY {
            void action() {
                System.out.println("Spraying the underbody");
            }
        },
        WHEELWASH {
            void action() {
                System.out.println("Washing the wheels");
            }
        },
        PREWASH {
            void action() {
                System.out.println("Loosening the dirt");
            }
        };

        abstract void action();
    }

    private EnumSet<Cycle> cycles = EnumSet.of(Cycle.PREWASH, Cycle.UNDERBODY);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    private void washCar() {
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();
        wash.add(Cycle.WHEELWASH);
        System.out.println(wash);
        wash.washCar();
    }
}

/*

输出：

[UNDERBODY, PREWASH]
Spraying the underbody
Loosening the dirt
[UNDERBODY, WHEELWASH, PREWASH]
Spraying the underbody
Washing the wheels
Loosening the dirt

 */