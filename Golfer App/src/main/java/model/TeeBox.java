package model;

public class TeeBox {
    private int teeBoxId;
    private int courseId;
    private String teeBoxName;
    private String color;
    private int distance;
    private int par;
    private double courseRating;
    private int slopeRating;

    public TeeBox(int teeBoxId, int courseId, String teeBoxName, String color, int distance, int par, double courseRating, int slopeRating) {
        this.teeBoxId = teeBoxId;
        this.courseId = courseId;
        this.teeBoxName = teeBoxName;
        this.color = color;
        this.distance = distance;
        this.par = par;
        this.courseRating = courseRating;
        this.slopeRating = slopeRating;
    }

    public int getTeeBoxId() {
        return teeBoxId;
    }

    public void setTeeBoxId(int teeBoxId) {
        this.teeBoxId = teeBoxId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTeeBoxName() {
        return teeBoxName;
    }

    public void setTeeBoxName(String teeBoxName) {
        this.teeBoxName = teeBoxName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public int getSlopeRating() {
        return slopeRating;
    }

    public void setSlopeRating(int slopeRating) {
        this.slopeRating = slopeRating;
    }

    @Override
    public String toString() {
        return "TeeBox{" +
                "teeBoxId=" + teeBoxId +
                ", courseId=" + courseId +
                ", teeBoxName='" + teeBoxName + '\'' +
                ", color='" + color + '\'' +
                ", distance=" + distance +
                ", par=" + par +
                ", courseRating=" + courseRating +
                ", slopeRating=" + slopeRating +
                '}';
    }
}