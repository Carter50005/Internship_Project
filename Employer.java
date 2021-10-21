import java.util.ArrayList;

public class Employer extends User{

    private String companyName;
    private String companyDescription;
    private String companyLocation;
    private int companyRating;
    private ArrayList<JobListing> companyListings;
    private ArrayList<Review> reviews;

    public Employer(String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        super(username, password, 'e');
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = new ArrayList<JobListing>();
    }

    public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation, int aRating, ArrayList<JobListing> aListings, ArrayList<Review> aReviews) {
        super(username, password, 'e', uUID);
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = aListings;
        this.reviews = aReviews;
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
    public int getCompanyRating() {
        return this.companyRating;
    }
    public ArrayList<JobListing> getCompanyListings() {
        return this.companyListings;
    }
    public ArrayList<Review> getReviews() {
        return this.reviews;
    }
}
