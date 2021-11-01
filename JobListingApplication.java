import java.util.ArrayList;

public class JobListingApplication {

    private UserList users;
    private JobListingsList jobs;
    private  User user;
    private Student studentUser;
    private Employer employerUser;
    private Admin adminUser;
    private static JobListingApplication jobListingApplication;

    private JobListingApplication() {
        users  = UserList.getInstance();
        jobs = JobListingsList.getInstance();
    }

    public boolean createStudentAccount(String username, String password, String studentID, String firstName, String lastName, String email) {
        if(!users.findAccount(username,password)) {
            users.addStudent(new Student(username, password, studentID, firstName, lastName, email));
            return true;
        } else {
            return false;
        }
    }

    public Resume createResume() {
        return new Resume(studentUser);
    }

    public void addResume(Resume resume) {
        studentUser.addResume(resume);
        users.addResume(studentUser, resume);
    }

    public JobListing createListing(String title, String postedDate, String expirationDate, String location, String jobPay) {
        return new JobListing(title, postedDate, expirationDate, location, Integer.parseInt(jobPay), employerUser.getUUID());
    }

    public void addJobListing(JobListing listing) {
        employerUser.addListing(listing);
        jobs.addListing(listing);
    }

    public boolean createEmployerAccount(String username, String password, String aName, String aDescription, String aLocation) {
        if(!users.findAccount(username,password)) {
            users.addEmployer(new Employer(username, password, aName, aDescription, aLocation));
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
        setChild(user);
        return true;
    }

    public void setChild(User user) {
        if(user.getType().equalsIgnoreCase("s") && (loginStudent(user) != null)) {
            this.user = loginStudent(user);
            this.studentUser = loginStudent(user);
        }
        else if(user.getType().equalsIgnoreCase("e") && (loginEmployer(user) != null)) {
            this.user = loginEmployer(user);
            this.employerUser = loginEmployer(user);
        }
        else if(user.getType().equalsIgnoreCase("a") && (loginAdmin(user) != null)) {
            this.user = loginAdmin(user);
            this.adminUser = loginAdmin(user);
        }
    }

    public String findAccountType() {
        return user.getType();
    }

    public Student loginStudent(User user) {
        ArrayList<Student> students = users.getStudents();
        for(Student student : students) {
            if(user.getUUID() == student.getUUID()) {
                return student;
            }
        }
        return null;
    }

    public Employer loginEmployer(User user) {
        ArrayList<Employer> employers = users.getEmployers();
        for(Employer employer : employers) {
            if(user.getUUID() == employer.getUUID()) {
                return employer;
            }
        }
        return null;
    }

    public Admin loginAdmin(User user) {
        ArrayList<Admin> admins = users.getAdmins();
        for(Admin admin : admins) {
            if(user.getUUID() == admin.getUUID()) {
                return admin;
            }
        }
        return null;
    }

    public ArrayList<JobListing> searchListings(String keyword) {
        return jobs.searchListings(keyword);
    }

    public void logout() {
        DataWriter.saveUsers(users.getUsers());
        DataWriter.saveJobListing(jobs.getJobListings());
        System.exit(0);
    }

    public void applyStudent(JobListing listing) {
        listing.apply(studentUser);
        jobs.updateListing(listing);
    }

}
