package model;


public class Holes {
    private int holeId;
    private int courseId;
    private int holeNumber;
    private int par;
    private int distance;
    private boolean hazard;

    public Holes(int holeId, int courseId, int holeNumber, int par, int distance, boolean hazard) {
        this.holeId = holeId;
        this.courseId = courseId;
        this.holeNumber = holeNumber;
        this.par = par;
        this.distance = distance;
        this.hazard = hazard;
    }

    public Holes() {

    }

    public int getHoleId() {
        return holeId;
    }

    public void setHoleId(int holeId) {
        this.holeId = holeId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {
        this.holeNumber = holeNumber;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isHazard() {
        return hazard;
    }

    public void setHazard(boolean hazard) {
        this.hazard = hazard;
    }

    @Override
    public String toString() {
        return "Holes{" +
                "holeId=" + holeId +
                ", courseId=" + courseId +
                ", holeNumber=" + holeNumber +
                ", par=" + par +
                ", distance=" + distance +
                ", hazard=" + hazard +
                '}';
    }
}
