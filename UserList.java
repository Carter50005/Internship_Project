import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;
    private String userUsername;
    private String userPassword;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null) {
            return new UserList();
        }
        return userList;
    }
    public User MakeAccount() {
        return null;
    }
    public boolean login(String username, String password) {
        Scanner keyboard = new Scanner(System.in);
        String User.getUsername =  username;
        String User.getPassword = password;
        String userUsername = keyboard.nextLine();
        if(this.userUsername == username) {
            return true;
        }
        else {
            return false;
        }
        String userPassword = keyboard.nextLine();
        if(this.userPassword == userPassword) {
            return true;
        }
        else {
            return false;
    public User login(String username, String password) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername() == username && users.get(i).getPassword() == password) {
                return users.get(i);
            }
        }
        return null;
    }

    public User findUser(String uUID) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUUID() == uUID) {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean containsUser(String username) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername() == username) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
}
