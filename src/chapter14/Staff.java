package chapter14;

import java.util.ArrayList;

/**
 * Created by shadowwingz on 2018-07-04 21:45
 */
public class Staff extends ArrayList<Position> {

    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title)
                    && position.getPerson() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title)
                    && position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff(
                "President",
                "CTO",
                "Marketing Manager",
                "Product Manager",
                "Project Lead",
                "Software Engineer",
                "Software Engineer",
                "Software Engineer",
                "Software Engineer",
                "Test Engineer",
                "Technical Writer");
        staff.fillPosition("President",
                new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosition("Project Lead",
                new Person("Janet", "Planner", "The Burbs"));
        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer",
                    new Person("Bob", "Coder", "Bright Light City"));
        }
        System.out.println(staff);
    }
}

/*
输出：

[Position{title='President',
person=Person{first='Me', last='Last', address='The Top, Lonely At'}},
Position{title='CTO', person=NullPerson},
Position{title='Marketing Manager', person=NullPerson},
Position{title='Product Manager', person=NullPerson},
Position{title='Project Lead',
person=Person{first='Janet', last='Planner', address='The Burbs'}},
Position{title='Software Engineer',
person=Person{first='Bob', last='Coder', address='Bright Light City'}},
Position{title='Software Engineer', person=NullPerson},
Position{title='Software Engineer', person=NullPerson},
Position{title='Software Engineer', person=NullPerson},
Position{title='Test Engineer', person=NullPerson},
Position{title='Technical Writer', person=NullPerson}]

 */