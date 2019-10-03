package chapter21;

/**
 * created by shadowwingz on 2019-10-03 12:13
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
