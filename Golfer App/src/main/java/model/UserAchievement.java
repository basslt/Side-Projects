package model;

import java.util.Date;

public class UserAchievement {
    private int userAchievementId;
    private int userId;
    private int achievementId;
    private Date achievedDate;

    public UserAchievement(int userAchievementId, int userId, int achievementId, Date achievedDate) {
        this.userAchievementId = userAchievementId;
        this.userId = userId;
        this.achievementId = achievementId;
        this.achievedDate = achievedDate;
    }

    public int getUserAchievementId() {
        return userAchievementId;
    }

    public void setUserAchievementId(int userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    public Date getAchievedDate() {
        return achievedDate;
    }

    public void setAchievedDate(Date achievedDate) {
        this.achievedDate = achievedDate;
    }

    @Override
    public String toString() {
        return "UserAchievement{" +
                "userAchievementId=" + userAchievementId +
                ", userId=" + userId +
                ", achievementId=" + achievementId +
                ", achievedDate=" + achievedDate +
                '}';
    }
}


