import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

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
    public User login(String username, String password) {
        User.getUsername =  username;
        User.getPassword = password;
        String userUsername = keybaord.nextLine();
        if(this.username == username) {
            return true;
            System.out.print("Enter Password");
        }
        else {
            return false;
            System.out.println("Wrong password");
        }
        String userPassword = keybaord.nextLine();
        if(this.password == userPassword) {
            return true;
            System.out.print("Welcome");
        }
        else {
            return false;
            System.out.println("Wrong password");
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
