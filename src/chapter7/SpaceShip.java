package chapter7;

/**
 * Created by shadowwingz on 2018/5/8 0008.
 *
 * SpaceShip 直接继承了 SpaceShipControls，
 * 导致 SpaceShipControls 的所有方法在 SpaceShip 中都暴露了出来
 * （SpaceShip 可以调用 SpaceShipControls 的所有方法）
 */
public class SpaceShip extends SpaceShipControls {

    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
