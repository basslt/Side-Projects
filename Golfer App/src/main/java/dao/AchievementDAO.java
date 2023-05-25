package dao;

import model.Achievement;

import java.util.List;

public interface AchievementDAO {
    Achievement getAchievementById(int achievementId);
    List<Achievement> getAllAchievements();
    void addAchievement(Achievement achievement);
    void updateAchievement(Achievement achievement);
    void deleteAchievement(Achievement achievement);
}
