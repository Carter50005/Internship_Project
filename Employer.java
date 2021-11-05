import java.util.ArrayList;

public class Employer extends User{

    private String companyName;
    private String companyDescription;
    private String companyLocation;
    private int companyRating;
    private ArrayList<JobListing> companyListings;
    private ArrayList<Review> reviews;

    public Employer(String username, String password, String aName, String aDescription, String aLocation) {
        super(username, password, "e");
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = 0;
        this.companyListings = new ArrayList<JobListing>();
        this.reviews = new ArrayList<Review>();
    }

    public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation) {
        super(username, password, "e", uUID);
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = 0;
        this.companyListings = new ArrayList<JobListing>();
        this.reviews = new ArrayList<Review>();
    }

    public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        super(username, password, "e", uUID);
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = new ArrayList<JobListing>();
        this.reviews = new ArrayList<Review>();
    }

    /*public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation, int aRating, ArrayList<JobListing> aListings, ArrayList<Review> aReviews) {
        super(username, password, "e", uUID);
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = aListings;
        this.reviews = aReviews;
    }*/

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

    public void editAccount(String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        if(username.length()>0) {
            super.username = username;
        }
        if(password.length()>0) {
            super.password = password;
        }
        if(aName.length()>0) {
            this.companyName = aName;
        }
        if(aDescription.length()>0) {
            this.companyDescription = aDescription;
        }
        if(aLocation.length()>0) {
            this.companyLocation = aLocation;
        }
    }
    public void addListing(JobListing listing) {
        listing.setEmployer(this);
        if(!companyListings.contains(listing)) {
            companyListings.add(listing);
        }
    }

    public void removeListing(JobListing listing) {
        if(companyListings.contains(listing)) {
            companyListings.remove(listing);
        }
    }

    public String getUUID() {
        return this.uUID;
    }

    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    public void remove(Employer review) {
        review.remove(review);
    }

    public static void remove(Review review) {
        review.remove(review);
    }
}
