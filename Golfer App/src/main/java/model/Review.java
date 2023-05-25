package model;

import java.util.Date;

public class Review {
    private int reviewId;
    private int courseId;
    private String reviewerName;
    private Date reviewDate;
    private int rating;
    private String comments;

    public Review(int reviewId, int courseId, String reviewerName, Date reviewDate, int rating, String comments) {
        this.reviewId = reviewId;
        this.courseId = courseId;
        this.reviewerName = reviewerName;
        this.reviewDate = reviewDate;
        this.rating = rating;
        this.comments = comments;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", courseId=" + courseId +
                ", reviewerName='" + reviewerName + '\'' +
                ", reviewDate=" + reviewDate +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }

}
