public class User {
    
    private String username;
    private String password;
    private char type;

    public User(String username, String password) {
        this. username = username;
        this.password = password;
        this.type = type;
    }

    public boolean verifyUsername() {
        return username();
    }

    private boolean username() {
        return false;
    }

    public boolean verifyPassowrd() {
        return password();
    }

    private boolean password() {
        return false;
    }
}
