import java.util.ArrayList;

public class JobListingsList {
    
    private ArrayList<JobListing> jobListings;

    public JobListingsList() {
        //jobListings = DataLoader.getJobListings();
    }

    public void addListing(JobListing jobListing) {
        if(!contains(jobListing)) {
            jobListings.add(jobListing);
        }
    }

    public ArrayList<JobListing> searchListings(String keyWord) {
        ArrayList<JobListing> ret = new ArrayList<JobListing>();
        for(int i=0;i<jobListings.size();i++) {
            if(jobListings.get(i).toString().contains(keyWord)) {
                ret.add(jobListings.get(i));
            }
        }
        return ret;
    }

    public ArrayList<JobListing> sortListings(SortType sortType) {
        
        
    }

    public boolean contains(JobListing jobListing) {
        for(int i=0;i<jobListings.size();i++) {
            if(jobListings.get(i) == jobListing) {
                return true;
            }
        }
        return false;
    }

    public boolean containsString(String string, String keyWord) {
        if(string.contains(keyWord)) {
            return true;
        }
        return false;
    }

    public void deleteListing(JobListing jobListing) {
        jobListings.remove(jobListing);
    }
}
