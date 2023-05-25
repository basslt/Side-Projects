package model;

public class Achievement {
    private int achievementId;
    private String achievementName;
    private String description;
    private String requirement;

    public Achievement(int achievementId, String achievementName, String description, String requirement) {
        this.achievementId = achievementId;
        this.achievementName = achievementName;
        this.description = description;
        this.requirement = requirement;
    }


    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "achievementId=" + achievementId +
                ", achievementName='" + achievementName + '\'' +
                ", description='" + description + '\'' +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}