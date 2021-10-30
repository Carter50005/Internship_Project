import java.util.Random;

public class User {

    protected String username;
    protected String password;
    protected char type;
    protected String uUID;
    private Random random = new Random();

    public User(String username, String password, char type) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.uUID = createUUID();
    }

    public User(String username, String password, char type, String uUID) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.uUID = uUID;
    }

    public boolean verifyUsername(String username) {
        if(this.username == username) {
            return true;
        }
        return false;
    }

    public String getUUID() {
        return this.uUID;
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

    public String getPassword() {
        return this.password;
    }

    public char getType() {
        return this.type;
    }

    public String createUUID() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return String.valueOf(alphabet.charAt(random.nextInt(alphabet.length())))+uUIDNumbers();
    }

    private String uUIDNumbers() {
        String ret = "";
        for(int i=0;i<6;i++) {
            ret += random.nextInt(9);
        }
        return ret;
    }

    public boolean contains(JobListing listing) {
        return false;
    }

}
