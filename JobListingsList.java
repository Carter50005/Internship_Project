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
    }

    public void setEmployers(ArrayList<Employer> employers) {
        for(Employer employer : employers) {
            for(JobListing listing : jobListings) {
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
        return jobListings;
    }

    public void addListing(JobListing jobListing) {
        jobListings.add(jobListing);
    }

    public static void updateListing(JobListing listing) {
        for(int i=0;i<jobListings.size();i++) {
            if(jobListings.get(i).getUUID().equalsIgnoreCase(listing.getUUID())) {
                jobListings.remove(jobListings.get(i));
                jobListings.add(listing);
            }
        }
    }

    public ArrayList<JobListing> searchListings(String keyWord) {
        ArrayList<JobListing> ret = new ArrayList<JobListing>();
        for(int i=0;i<jobListings.size();i++) {
            if(jobListings.get(i).toString().toLowerCase().contains(keyWord.toLowerCase())) {
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
