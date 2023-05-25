package dao;

import model.Review;

import java.util.List;

public interface ReviewDAO {
    Review getReviewById(int reviewId);
    List<Review> getReviewsByCourseId(int courseId);
    void addReview(Review review);
    void updateReview(Review review);
    void deleteReview(Review review);
}
