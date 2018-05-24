package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 *
 * 代理的好处：可以拥有更多的控制力（不太理解）
 */
public class SpaceShipDelegation {

    private String name;

    /**
     * 持有一个 SpaceShipControls 的实例
     */
    private SpaceShipControls controls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    // 代理方法

    /**
     * 调用代理对象的 up 方法，
     * 内部实际上调用了 SpaceShipControls 的 up 方法
     */

    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
}
