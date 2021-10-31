public class Review {

    private int rating;
    private String review;
    private String reviewerID;
    private String revieweeID;

    public Review(int rating, String review, String reviewer, String reviewee) {
        this.rating = rating;
        this.review = review;
        this.reviewerID = reviewer;
        this.revieweeID = reviewee;
    }

    public String toString() {
        return "Rating: "+rating+"\nReview: "+review;
    }

    public String getReviewerID() {
        return this.reviewerID;
    }

    public String getRevieweeID() {
        return this.revieweeID;
    }

    public int getRating() {
        return this.rating;
    }

    public String getReview() {
        return this.review;
    }

    public void addReview() {

    }

    public void removeReview(Student review) {
        review.remove(review);
    }

    public void removeReview(Employer review) {
        review.remove(review);
    }

    public void remove(Review review) {
        review.remove(review);
    public int getRating() {
        return this.rating;
    }

    public String getReview() {
        return this.review;
    }
}
