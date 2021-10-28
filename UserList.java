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
        Scanner keyboard = new Scanner(System.in);
        String User.Username = keyboard.nextLine();
        String User.Password = keyboard.nextLine();

    }
    public static boolean login(String username, String password) {
        Scanner keyboard = new Scanner(System.in);
        String User.Username =  username;
        String User.Password = password;
        String userUsername = keyboard.nextLine();
        if(userUsername == username) {
            return true;
        }
        else {
            return false;
        }
        String userPassword = keyboard.nextLine();
        if(userPassword == Password) {
            return true;
        }
        else {
            return false;
        }
 
    }
    public User findUser(String uUID) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUUID() == uUID) {
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }
}
