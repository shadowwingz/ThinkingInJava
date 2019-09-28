package chapter20.database;

@DBTable(name = "MEMBER")
public class Member {
    // 30 会赋值给 value 字段，虽然并没有显式赋值 value = 30
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    // handle 是主键，所以要设置 primaryKey，由于 value 不是唯一被赋值的元素，
    // 所以，要对 value 赋值，需要显式对 value 赋值，value = 30
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
