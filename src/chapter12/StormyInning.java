package chapter12;

/**
 * Created by shadowwingz on 2018-06-23 18:19
 *
 * 父类的方法抛出异常，子类的方法可以抛，也可以不抛，
 *
 * 因为父类的方法抛出异常，那么别人调用父类的方法时，
 * 就会做异常处理，这时把实现类换成子类的对象，
 * 如果子类的方法不抛出异常，那大不了不 catch 异常，也不会出问题。
 *
 * 父类的方法没抛出异常，子类的方法一定不可以抛异常
 *
 * 因为父类的方法没抛出异常，那么别人调用父类的方法时，
 * 就不会做异常处理，但是如果把实现类换成子类的对象，
 * 如果子类的方法抛出异常了，因为没做异常处理，就会出问题。
 */
class BaseballException extends Exception{

}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

abstract class Inning {

    /**
     * 构造方法声明抛异常，但实际上没有抛出
     */
    public Inning() throws BaseballException {
    }

    /**
     * 只声明抛异常，但实际上没有抛出
     */
    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {

    }
}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

class PopFoul extends Foul {

}

interface Storm {

    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {

    }

    /**
     * 如果父类中的方法没有抛异常，
     * 那么子类重写的方法也不能抛异常
     */
//    @Override
//    public void walk() throws PopFoul {
//
//    }

//    @Override
//    public void event() throws RainedOut  {
//    }

    /**
     * 如果父类中的方法抛异常，
     * 那么子类重写的方法可以不抛异常
     */
    @Override
    public void event() {

    }

    public void atBat() throws PopFoul {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            e.printStackTrace();
        } catch (RainedOut e) {
            e.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }

        /**
         * 实现类不一样，要捕获的异常类型也不一样
         */
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            e.printStackTrace();
        } catch (Foul e) {
            e.printStackTrace();
        } catch (RainedOut e) {
            e.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
