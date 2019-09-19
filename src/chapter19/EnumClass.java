package chapter19;

enum Shrubbery {
    GROUND,
    CRAWLING,
    HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            /**
             * ordinal 方法返回一个 int 值，这个每个 enum 实例在声明时的次序
             */
            System.out.println(s + " ordinal " + s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING));
            System.out.println(s.equals(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            // name() 相当于 toString()
            System.out.println(s.name());
            System.out.println("=====");
        }
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // 根据给定的名字返回相应的 enum 实例
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
