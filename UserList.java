import java.util.ArrayList;

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
    public User login(String username) {
        return null;
    }
    public User findUser(String username) {
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername() == username) {
                return users.get(i);
            }
        }
        return null;
    }
}