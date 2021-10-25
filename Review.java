
public class Review {
    
    private int rating;
    private String review;
    private User reviewer;
    private User reviewee;

    public Review(int rating, String review, User reviewer, User reviewee) {
        this.rating = rating;
        this.review = review;
        this.reviewer = reviewer;
        this.reviewee = reviewee;
    }

    public String toString() {
        return "Rating: "+rating+"\nReview: "+review;
    }

    public User getReviewer() {
        return this.reviewer;
    }

    public User getReviewee() {
        return this.reviewee;
    }

    public void addReview() {
        
    }
}
