import java.util.ArrayList;

public class Student extends User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private ArrayList<JobListing> wishList;
    private ArrayList<Resume> resumes;
    private ArrayList<Review> reviews;

    public Student(String username, String password, String studentID, String firstName, String lastName, String email, String phoneNumber) {
        super(username, password, "s", studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.resumes = new ArrayList<Resume>();
        this.reviews = new ArrayList<Review>();
        this.wishList = new ArrayList<JobListing>();
    }

    public Student(String username, String password, String studentID, String firstName, String lastName, String email, String phoneNumber, ArrayList<Resume> resumes, ArrayList<Review> reviews, ArrayList<JobListing> wishList)  {
        super(username, password, "s", studentID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.resumes = resumes;
        this.reviews = reviews;
        this.wishList = wishList;
    }



    public void removeReview(Review review) {
        reviews.remove(review);
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
        new Review(rating, review, getUUID(), reviewee.getUUID());
    }

    public String toString() {
        return "First name: "+firstName+"\nLast name: "+lastName+"\nEmail: "+email+"\nPhone number: "+phoneNumber;
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

    public ArrayList<JobListing> getWishList() {
        return this.wishList;
    }

    public ArrayList<Resume> getResumes() {
        return this.resumes;
    }

    public ArrayList<Review> getReviews() {
        return this.reviews;
    }

    public void setResumes(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addResume(Resume resume) {
        resumes.add(resume);
    }
 
}
