public class JobListingApplication {
    
    private UserList users;
    private JobListingsList jobs;
    private User user;

    public JobListingApplication() {
        users  = UserList.getInstance();
        jobs = JobListingsList.getInstance();
    }

    public boolean createAccount(String username, String password, char type) {
        if(!users.containsUser(username)) {
            users.createAccount();
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
        users.
    }
}
