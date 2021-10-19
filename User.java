public class User {
    
    private String username;
    private String password;
    private Privaledges privaledges;
    private char type;

    public User(String username, String password, char type, Privaledges privaledges) {
        this. username = username;
        this.password = password;
        this.privaledges = privaledges;
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
