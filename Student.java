import java.util.ArrayList;

public class Student extends User {

    private String studentID;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<JobListing> wishList;
    private ArrayList<Resume> resumes;
    private ArrayList<Review> reviews;

    public Student(String username, String password, String studentID, String firstName, String lastName, String email) {
        super(username, password, 's');
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = new ArrayList<Resume>();
        this.reviews = new ArrayList<Review>();
        this.wishList = new ArrayList<JobListing>();
    }

    public Student(String username, String password, String studentID, String firstName, String lastName, String email, ArrayList<Resume> resumes, ArrayList<Review> reviews)  {
        super(username, password, 's');
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = resumes;
        this.reviews = reviews;
        this.wishList = wishList;
    }

    public void editAccount() {

    }

    public String generateResume() {
        return "";
    }

    public void applyForJob() {

    }

    public void addToWishList(JobListing jobListing) {
        wishList.add(jobListing);
    }

    public void removeFromWishList(JobListing jobListing) {
        wishList.remove(jobListing);
    }

    public void reviewEmployer() {

    }

    public String toString() {
        return "";
    }
 
}
