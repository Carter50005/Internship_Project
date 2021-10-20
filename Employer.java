import java.util.ArrayList;

public class Employer extends User{
    
    public String companyName;
    public String companyDescription;
    public String companyLocation;
    public int companyRating;
    public ArrayList<JobListing> companyListings;

    public Employer(String username, String password, String aName, String aDescription, String aLocation, int aRating) {
        super(username, password, 'e');
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
    }

    public Employer(String username, String password, String aName, String aDescription, String aLocation, int aRating, ArrayList<JobListing> aListings) {
        super(username, password, 'e');
        this.companyName = aName;
        this.companyDescription = aDescription;
        this.companyLocation = aLocation;
        this.companyRating = aRating;
        this.companyListings = aListings;
    }
}
