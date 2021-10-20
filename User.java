public class User {
    
    protected String username;
    protected String password;
    protected char type;

    public User(String username, String password, char type) {
        this. username = username;
        this.password = password;
        this.type = type;
    }

    public boolean verifyUsername(String username) {
        if(this.username == username) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean verifyPassowrd(String password) {
        if(this.password == password) {
            return true;
        }
        return false;
    }

    public char getType() {
        return this.type;
    }

}
