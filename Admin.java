
public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, "a");
    }

    public Admin(String username, String password, String uUID) {
        super(username, password, "a", uUID);
    }

    public void editReview(Review review, Review editedReview) {
        review = editedReview;
    }

    public void deleteUser(User user) {
        UserList.getInstance().getUsers().remove(user);
        JobListingsList listings = JobListingsList.getInstance();
        if(user.getType().equalsIgnoreCase("s")) {
            for(int i = 0; i<listings.getJobListings().size(); i++) {
                for (int j = 0; j<listings.getJobListings().get(i).getApplicants().size(); j++)
                if(listings.getJobListings().get(i).getApplicants().get(j).equals(user)) {
                    listings.getJobListings().get(i).removeApplicant(listings.getJobListings().get(i).getApplicants().get(j));
                }
            }
        }
        else if(user.getType().equalsIgnoreCase("e")) {
            for(int i = 0; i<listings.getJobListings().size(); i++) {
                listings.deleteListing(listings.getJobListings().get(i));
            }
        }
    }

    public void deleteReview(Student student, Review review) {
        if(student.getReviews().contains(review)) {
            student.removeReview(review);
        }
    }
            
    public void deleteReview(Employer employer, Review review) {
        if(employer.getReviews().contains(review)) {
                employer.deleteReview(review);
        } 
    }
    


    public void editUser(User user, User editedUser) {
        user = editedUser;
    }
}
