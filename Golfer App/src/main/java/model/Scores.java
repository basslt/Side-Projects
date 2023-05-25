package model;

import java.time.LocalDate;

public class Scores {
    private int scoreId;
    private int userId;
    private int courseId;
    private LocalDate datePlayed;
    private int totalScore;
    private int totalPutts;
    private int totalFairwaysHit;
    private int totalGir;


    public Scores(int scoreId, int userId, int courseId, LocalDate datePlayed, int totalScore, int totalPutts, int totalFairwaysHit, int totalGir) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.courseId = courseId;
        this.datePlayed = datePlayed;
        this.totalScore = totalScore;
        this.totalPutts = totalPutts;
        this.totalFairwaysHit = totalFairwaysHit;
        this.totalGir = totalGir;
    }

    public Scores() {

    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(LocalDate datePlayed) {
        this.datePlayed = datePlayed;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalPutts() {
        return totalPutts;
    }

    public void setTotalPutts(int totalPutts) {
        this.totalPutts = totalPutts;
    }

    public int getTotalFairwaysHit() {
        return totalFairwaysHit;
    }

    public void setTotalFairwaysHit(int totalFairwaysHit) {
        this.totalFairwaysHit = totalFairwaysHit;
    }

    public int getTotalGir() {
        return totalGir;
    }

    public void setTotalGir(int totalGir) {
        this.totalGir = totalGir;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", datePlayed=" + datePlayed +
                ", totalScore=" + totalScore +
                ", totalPutts=" + totalPutts +
                ", totalFairwaysHit=" + totalFairwaysHit +
                ", totalGir=" + totalGir +
                '}';
    }

    public ScoreDetail[] getScoreDetails() {
        return new ScoreDetail[0];
    }

}
