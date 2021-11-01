import java.util.ArrayList;

public class JobListingsList {
    
    private static ArrayList<JobListing> jobListings;
    private static JobListingsList jobListingList;

    public JobListingsList() {
        if(DataLoader.getJobListings() != null) {
            jobListings = DataLoader.getJobListings();
        }
        else {
            jobListings = new ArrayList<JobListing>();
        }
        setEmployers();
        
    }

    private void setEmployers() {
        for(JobListing listing : jobListings) {
            for(Employer employer : UserList.getInstance().getEmployers()) {
                if(listing.getEmployerID().equalsIgnoreCase(employer.getUUID())) {
                    listing.setEmployer(employer);
                }
            }
        }
    }

    public static JobListingsList getInstance() {
        if(jobListingList == null) {
            return new JobListingsList();
        }
        return jobListingList;
    }
    public ArrayList<JobListing> getJobListings() {
        return this.jobListings;
    }

    public void addListing(JobListing jobListing) {
        if(!contains(jobListing)) {
            jobListings.add(jobListing);
        }
    }

    public void updateListing(JobListing listing) {
        for(JobListing jobListing : jobListings) {
            if(jobListing.getUUID().equalsIgnoreCase(listing.getUUID())) {
                jobListing = listing;
            }
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
