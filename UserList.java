import java.util.ArrayList;
import java.util.Scanner;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;
    private ArrayList<Student> students;
    private ArrayList<Employer> employers;
    private ArrayList<Admin> admins;
    private String userUsername;
    private String userPassword;

    private UserList() {
        users = DataLoader.getUsers();
        students = new ArrayList<Student>();
        employers = new ArrayList<Employer>();
        admins = new ArrayList<Admin>();
    }

    public static UserList getInstance() {
        if(userList == null) {
            return new UserList();
        }
        return userList;
    }
    public User MakeAccount() {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).username == userUsername) {
                return User.Username;
            }

    }
    /*public static boolean login(String username, String password) {
        Scanner keyboard = new Scanner(System.in);
        String User.Username =  username;
        String User.Password = password;
        String User.getUsername =  username;
        String User.getPassword = password;
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
        */ 

    public User login(String username, String password) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername().equalsIgnoreCase(username) && users.get(i).getPassword().equalsIgnoreCase(password)) {
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

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Employer> getEmployers() {
        return this.employers;
    }

    public ArrayList<Admin> getAdmins() {
        return this.admins;
    }

}
