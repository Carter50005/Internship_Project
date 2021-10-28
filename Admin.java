
public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, 'a');
    }

    public Admin(String username, String password, String uUID) {
        super(username, password, 'a', uUID);
    }

    public void editReview(Review review, Review editedReview) {
        review = editedReview;
    }

    public void deleteUser(User user) {
        UserList.getInstance().getUsers().remove(user);
        JobListingsList listings = JobListingsList.getInstance();
        if(user.getType()=='s') {
            for(int i = 0; i<listings.getJobListings().size(); i++) {
                for (int j = 0; j<listings.getJobListings().get(i).getApplicants().size(); j++)
                if(listings.getJobListings().get(i).getApplicants().get(j).getStudent().equals(user)) {
                    listings.getJobListings().get(i).removeApplicant(listings.getJobListings().get(i).getApplicants().get(j));
                }
            }
        }
        else if(user.getType()=='e') {
            for(int i = 0; i<user.getCompanyListings().size(); i++) {
                user.removeListing(user.getCompanyListings().get(i));
            }
        }
    }

    public void deleteReview(User user, Review review) {
        if(user.getType()=='s' || user.getType()=='e') {
            if(user.getReviews().contains(review)) {
                user.removeReview(review);
            }
        }
    }

    public void editUser(User user, User editedUser) {
        user = editedUser;
    }
}