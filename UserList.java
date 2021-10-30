import java.util.ArrayList;


public class UserList {
    private static UserList userList;
    private ArrayList<User> users = new ArrayList<User>();

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null) {
            return new UserList();
        }
        return userList;
    }

    public void createAccount(String username, String password, char type) {
        users.add(new User(username, password, type));
    }


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

    public User findType() {
        return null;
    }

    public boolean findAccount(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername() == username && users.get(i).getPassword() == password) {
                return true;
            }
        }
        return false;
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
