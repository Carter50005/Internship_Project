import java.util.UUID;

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
        
    }

    public void deleteReview(Review review) {

    }

    public void editUser(User user, User editedUser) {
        user = editedUser;
    }
}