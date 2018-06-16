package chapter10;

/**
 * Created by shadowwingz on 2018/6/16 0016.
 *
 * yolk 蛋黄
 */
class Egg {

    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        /**
         * 这里 new Yolk，
         * 创建的是 Egg 的内部类 Yolk 的对象，
         * 不是 BigEgg 的内部类 Yolk 的对象。
         *
         * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内。
         */
        y = new Yolk();
    }
}

public class BigEgg extends Egg {

    /**
     * 这里虽然也定义了一个 Yolk，
     * 但是和 Egg 的内部类 Yolk 并没有什么关系，
     * 如果想覆盖 Egg 的内部类 Yolk，
     * 需要让 BigEgg 的内部类 Yolk 继承（extends）Egg 的内部类 Yolk
     */
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}

/*
输出：

New Egg()
Egg.Yolk()

 */