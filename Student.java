import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student extends User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ArrayList<String> wishListIDS;
    private ArrayList<Resume> resumes;
    private ArrayList<Review> reviews;

    public Student(String username, String password, String studentID, String firstName, String lastName, String email) {
        super(username, password, 's', studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = new ArrayList<Resume>();
        this.reviews = new ArrayList<Review>();
        this.wishListIDS = new ArrayList<String>();
    }

    public Student(String username, String password, String studentID, String firstName, String lastName, String email, ArrayList<Resume> resumes, ArrayList<Review> reviews, ArrayList<String> wishList)  {
        super(username, password, 's', studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.resumes = resumes;
        this.reviews = reviews;
        this.wishListIDS = wishList;
    }

    public void editAccount() {

    }

    public void applyForJob() {

    }

    public void addToWishList(JobListing jobListing) {
        if(wishListIDS.contains(jobListing.getUUID())) {
            return;
        }
        wishListIDS.add(jobListing.getUUID());
    }

    public boolean removeFromWishList() {
        return true;
    }

    public void removeFromWishList(JobListing jobListing) {
        wishListIDS.remove(jobListing.getUUID());
    }

    public void reviewEmployer(int rating, String review, User reviewee) {
        new Review(rating, review, this.getUUID(), reviewee.getUUID());
    }

    public String toString() {
        return "";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public ArrayList<String> getWishList() {
        return this.wishListIDS;
    }

    public ArrayList<Resume> getResumes() {
        return this.resumes;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public void setResumes(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    } 

    public void setWishlist(ArrayList<String> listingIDS) {
        this.wishListIDS = listingIDS;
    }
 
}
