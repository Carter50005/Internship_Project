public class JobListingApplication {
    
    private UserList users;
    private JobListingsList jobs;
    private User user;

    public JobListingApplication() {
        users  = UserList.getInstance();
        jobs = JobListingsList.getInstance();
    }

    public boolean createAccount(String username, String password, char type) {
        if(!users.findAccount(username,password)) {
            users.createAccount(username,password,type);
            return true;
        } else {
            return false;
        }
    }

    public boolean login(String username, String password) {
        if(users.login(username, password) == null) {
            return false;
        }
        user = users.login(username, password);
        return true;
    }

    public char findAccountType() {
        return user.getType();
    }
}
