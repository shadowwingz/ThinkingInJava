package chapter19;

public enum SpaceShip {

    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        // 将每个单词的首字母改成大写
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}

/*

输出：

Scout
Cargo
Transport
Cruiser
Battleship
Mothership

 */