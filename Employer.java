import java.util.ArrayList;

public class Employer extends User{
    
    private String uUID;
    private String companyName;
    private String companyDescription;
    private String companyLocation;
    private int companyRating;
    private ArrayList<JobListing> companyListings;
    private ArrayList<Review> reviews;

    public Employer(String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        super(username, password, 'e');
        this.uUID = super.uUID;
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = new ArrayList<JobListing>();
    }

    public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation, int aRating, ArrayList<JobListing> aListings, ArrayList<Review> aReviews) {
        super(username, password, 'e');
        this.uUID = uUID;
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = aListings;
        this.reviews = aReviews;
    }

    //Getters
    public String getUUID() {
        return this.uUID;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    public String getCompanyDescription() {
        return this.companyDescription;
    }
    public String getCompanyLocation() {
        return this.companyLocation;
    }
    public int companyRating() {
        return this.companyRating;
    }
    public ArrayList<JobListing> getCompanyListings() {
        return this.companyListings;
    }
    public ArrayList<Review> reviews() {
        return this.reviews;
    }
}
