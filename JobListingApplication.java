public class JobListingApplication {

    private UserList users;
    private JobListingsList jobs;
    private User user;
    private static JobListingApplication jobListingApplication;

    private JobListingApplication() {
        users  = UserList.getInstance();
        jobs = JobListingsList.getInstance();
    }

    public boolean createAccount(String username, String password, String type) {
        if(!users.findAccount(username,password)) {
            users.createAccount(username,password,type);
            return true;
        } else {
            return false;
        }
    }

    public static JobListingApplication getInstance() {
        if(jobListingApplication == null) {
            return new JobListingApplication();
        }
        return jobListingApplication;
    }

    public boolean login(String username, String password) {
        if(users.login(username, password) == null) {
            return false;
        }
        user = users.login(username, password);
        return true;
    }

    public String findAccountType() {
        return user.getType();
    }
}
