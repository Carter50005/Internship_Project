import java.util.ArrayList;

public class Student {

    private String studentID;
    private String firstName;
    private String lastName;
    private ArrayList<String> resumes;
    private ArrayList<Review> review;
    private ArrayList<Experience> workExperience;
    private ArrayList<Experience> extraCurriculars;

    public Student(String username, String password) {
        resumes = new ArrayList<String>();
        review = new ArrayList<Review>();
        workExperience = new ArrayList<Experience>();
        extraCurriculars = new ArrayList<Experience>();
    }

    public void editAccount() {

    }

    public String generateResume() {
        return firstName + " " + lastName + "\n";
    }

    public void applyForJob() {

    }

    public void addToWishList() {

    }

    public boolean removeFromWishList() {
        return true;
    }

    public void reviewEmployer() {

    }

    public String toString() {
        return "";
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void addWorkExperience(Experience experience) {
        workExperience.add(experience);
    }

    public void addExtraCurricular(Experience experience) {
        extraCurriculars.add(experience);
    }
 
}
