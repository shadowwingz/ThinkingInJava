package chapter10;

/**
 * Created by shadowwingz on 2018/6/13 0013.
 *
 * 接口中可以放嵌套类
 */
public interface ClassInInterface {

    void howdy();

    /**
     * 接口中的任何类都自动的是 public 和 static 的
     * （可以从 ClassInInterface.class 看到）
     */
    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}

/*
输出：

Howdy!

 */