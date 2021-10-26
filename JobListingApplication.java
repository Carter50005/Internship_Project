public class JobListingApplication {
    
    private UserList users;
    private JobListingsList jobs;

    public JobListingApplication() {
        users  = UserList.getInstance();
        jobs = JobListingsList.getInstance();
    }

    public boolean createAccount(String username, String password, char type) {
        if(!findUser(username,password)) {
            users.createAccount();
        }
    }

    public boolean login(String username, String password) {
        if(!users.login(username, password)){
            return false;
        } else {
            return true;
        }
    }

    public char findAccountType() {
        users.
    }
}
