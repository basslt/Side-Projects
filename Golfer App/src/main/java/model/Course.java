package model;

public class Course {
    private int courseId;
    private String courseName;
    private String location;
    private int courseRating;
    private int slopeRating;

   ;

    public Course(int courseId, String courseName, String location, int courseRating, int slopeRating) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.location = location;
        this.courseRating = courseRating;
        this.slopeRating = slopeRating;
    }

    public Course() {

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

    public int getSlopeRating() {
        return slopeRating;
    }

    public void setSlopeRating(int slopeRating) {
        this.slopeRating = slopeRating;
    }
}
