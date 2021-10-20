import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    private UserList(ArrayList<User> users) {
        this.users = users; // TODO call dataloader.. this will NOT be in finished product. 
    }

    private UserList() {
        //users = DataLoader.getUsers; this WILL be in finished product
    }

    public static UserList getInstance() {
        return new UserList();
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