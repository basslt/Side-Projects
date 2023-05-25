package mlb;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

import java.util.Arrays;

public class Player {
    private String fullName;
    private String position;
    private int jerseyNumber;
    private int mlbDebutYear;
    private String birthDate;
    private String birthCountry;
    private String height;
    private String weight;
    private String throwsHand;
    private String batsHand;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getMlbDebutYear() {
        return mlbDebutYear;
    }

    public void setMlbDebutYear(int mlbDebutYear) {
        this.mlbDebutYear = mlbDebutYear;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getThrowsHand() {
        return throwsHand;
    }

    public void setThrowsHand(String throwsHand) {
        this.throwsHand = throwsHand;
    }

    public String getBatsHand() {
        return batsHand;
    }

    public void setBatsHand(String batsHand) {
        this.batsHand = batsHand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", jerseyNumber=" + jerseyNumber +
                ", mlbDebutYear=" + mlbDebutYear +
                ", birthDate='" + birthDate + '\'' +
                ", birthCountry='" + birthCountry + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", throwsHand='" + throwsHand + '\'' +
                ", batsHand='" + batsHand + '\'' +
                '}';
    }
}
