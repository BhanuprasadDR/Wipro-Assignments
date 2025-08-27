public class Singleresponsibility {
    public static void main(String[] args) {
        User user = new User("Bhanu");
        UserRepository repo = new UserRepository();
        repo.save(user);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserRepository {
    public void save(User user) {
        System.out.println("Saving user: " + user.getName());
    }
}
