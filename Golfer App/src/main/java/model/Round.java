package model;

import java.sql.Time;
import java.sql.Date;

public class Round {
    private int roundId;
    private int userId;
    private int courseId;
    private int teeBoxId;
    private int scoreId;
    private Date datePlayed;
    private String weatherConditions;
    private Time teeTime;
    private String teeBoxName;
    private int totalScore;
    private int totalPutts;
    private int totalFairwaysHit;
    private int totalGir;

    public Round(int roundId, int userId, int courseId, int teeBoxId, int scoreId, Date datePlayed, String weatherConditions, Time teeTime, String teeBoxName, int totalScore, int totalPutts, int totalFairwaysHit, int totalGir) {
        this.roundId = roundId;
        this.userId = userId;
        this.courseId = courseId;
        this.teeBoxId = teeBoxId;
        this.scoreId = scoreId;
        this.datePlayed = datePlayed;
        this.weatherConditions = weatherConditions;
        this.teeTime = teeTime;
        this.teeBoxName = teeBoxName;
        this.totalScore = totalScore;
        this.totalPutts = totalPutts;
        this.totalFairwaysHit = totalFairwaysHit;
        this.totalGir = totalGir;
    }

    public Round() {

    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
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

    public int getTeeBoxId() {
        return teeBoxId;
    }

    public void setTeeBoxId(int teeBoxId) {
        this.teeBoxId = teeBoxId;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public Time getTeeTime() {
        return teeTime;
    }

    public void setTeeTime(String teeTime) {
        this.teeTime = teeTime;
    }

    public String getTeeBoxName() {
        return teeBoxName;
    }

    public void setTeeBoxName(String teeBoxName) {
        this.teeBoxName = teeBoxName;
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
        return "Round{" +
                "roundId=" + roundId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", teeBoxId=" + teeBoxId +
                ", scoreId=" + scoreId +
                ", datePlayed=" + datePlayed +
                ", weatherConditions='" + weatherConditions + '\'' +
                ", teeTime='" + teeTime + '\'' +
                ", teeBoxName='" + teeBoxName + '\'' +
                ", totalScore=" + totalScore +
                ", totalPutts=" + totalPutts +
                ", totalFairwaysHit=" + totalFairwaysHit +
                ", totalGir=" + totalGir +
                '}';
    }
}
