import java.util.ArrayList;

public class Student extends User {

    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<JobListing> wishList;
    private ArrayList<Resume> resumes;
    private ArrayList<Review> reviews;

    public Student(String username, String password, String studentID, String firstName, String lastName, String email) {
        super(username, password, 's', studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = new ArrayList<Resume>();
        this.reviews = new ArrayList<Review>();
        this.wishList = new ArrayList<JobListing>();
    }

    public Student(String username, String password, String studentID, String firstName, String lastName, String email, ArrayList<Resume> resumes, ArrayList<Review> reviews, ArrayList<JobListing> wishList)  {
        super(username, password, 's', studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = resumes;
        this.reviews = reviews;
        this.wishList = wishList;
    }

    public void editAccount() {

    }

    public void applyForJob() {

    }

    public void addToWishList(JobListing jobListing) {
        if(wishList.contains(jobListing)) {
            return;
        }
        wishList.add(jobListing);
    }

    public boolean removeFromWishList() {
        return true;
    }

    public void removeFromWishList(JobListing jobListing) {
        wishList.remove(jobListing);
    }

    public void reviewEmployer(int rating, String review, User reviewee) {
        new Review(rating, review, this, reviewee);
    }

    public String toString() {
        return "";
    }

    public String getFirstName() {
        return this.firstName;
    }

}
