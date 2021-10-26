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

    public Employer(String uUID, String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        super(username, password, 'e', uUID);
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = new ArrayList<JobListing>();
        this.reviews = new ArrayList<Review>();
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
            this.Description = aDescription;
        }
        if(aLocation.length()>0) {
            this.companyLocation = aLocation;
        }
    }
    public void addListing(JobListing listing) {
        listing.setEmployer(this);
        companyListings.add(listing);
        JobListingList.getInstance().addListing(listing);
    }
    public void removeListing(JobListing listing) {
        if(companyListings.contains(listing)) {
            companyListings.remove(listing);
        }
        if(JobListingList.getInstance().contains(listing)) {
            JobListingList.getInstance().remove(listing);
        }
        for(int i = 0; i<UserList.getInstance.getUsers().length; i++) {
            if(UserList.getInstance.getUsers().get(i).getType=='s' && UserList.getInstance.getUsers().get(i).getWishList.contains(listing)) {
                UserList.getInstance.getUsers().get(i).removeFromWishList(listing);
            }
        }
    }

    public void removeReview(Review review) {
        reviews.remove(review);
    }
}
