import java.util.List;

public class User {
    private String name;
    private String email;

    public User(String name, String emial) {
        this.name = name;
        this.email = emial;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
