import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.getName().compareTo(u2.getName());
    }

    public class Main {
        public static void main(String[] args) {
            // Sample Input 1
            List<User> users1 = Arrays.asList(
                    new User("Mike"),
                    new User("Ginger"),
                    new User("Alice"),
                    new User("Bob")
            );

            Collections.sort(users1, new UserComparator());

            System.out.println("Sample Output 1:");
            for (User user : users1) {
                System.out.println(user);
            }

            // Sample Input 2
            List<User> users2 = Arrays.asList(
                    new User("microprogrammer"),
                    new User("Moses"),
                    new User("Chloe"),
                    new User("user")
            );

            Collections.sort(users2, new UserComparator());

            System.out.println("Sample Output 2:");
            for (User user : users2) {
                System.out.println(user);
            }
        }
    }
}