package model;

public class GolfBag {
    private int bagId;
    private int userId;
    private String clubName;
    private String brand;
    private String clubType;
    private int loft;
    private String shaftFlex;
    private String grip;
    private String balls;
    private String glove;
    private String rangFinder;

    public GolfBag(int bagId, int userId, String clubName, String brand, String clubType, int loft, String shaftFlex, String grip, String balls, String glove, String rangFinder) {
        this.bagId = bagId;
        this.userId = userId;
        this.clubName = clubName;
        this.brand = brand;
        this.clubType = clubType;
        this.loft = loft;
        this.shaftFlex = shaftFlex;
        this.grip = grip;
        this.balls = balls;
        this.glove = glove;
        this.rangFinder = rangFinder;
    }

    public GolfBag() {

    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getGolferId() {
        return user;
    }

    public void setGolferId(int golferId) {
        this.golferId = golferId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClubType() {
        return clubType;
    }

    public void setClubType(String clubType) {
        this.clubType = clubType;
    }

    public int getLoft() {
        return loft;
    }

    public void setLoft(int loft) {
        this.loft = loft;
    }

    public String getShaftFlex() {
        return shaftFlex;
    }

    public void setShaftFlex(String shaftFlex) {
        this.shaftFlex = shaftFlex;
    }

    public String getGrip() {
        return grip;
    }

    public void setGrip(String grip) {
        this.grip = grip;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public String getGlove() {
        return glove;
    }

    public void setGlove(String glove) {
        this.glove = glove;
    }

    public String getRangFinder() {
        return rangFinder;
    }

    public void setRangFinder(String rangFinder) {
        this.rangFinder = rangFinder;
    }

    @Override
    public String toString() {
        return "GolfBag{" +
                "bagId=" + bagId +
                ", golferId=" + golferId +
                ", clubName='" + clubName + '\'' +
                ", brand='" + brand + '\'' +
                ", clubType='" + clubType + '\'' +
                ", loft=" + loft +
                ", shaftFlex='" + shaftFlex + '\'' +
                ", grip='" + grip + '\'' +
                ", balls='" + balls + '\'' +
                ", glove='" + glove + '\'' +
                ", rangFinder='" + rangFinder + '\'' +
                '}';
    }
}