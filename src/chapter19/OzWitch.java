package chapter19;

public enum OzWitch {
    
    WEST("a"),
    NORTH("b"),
    SOUTH("c");

    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}

/*

输出：

WEST: a
NORTH: b
SOUTH: c

 */