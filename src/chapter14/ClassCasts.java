package chapter14;

/**
 * Created by shadowwingz on 2018-06-28 20:21
 */
class Building {

}

class House extends Building {

}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;
    }
}
