package dao;

import model.UserAchievement;

import java.util.List;

public interface UserAchievementDAO {
    UserAchievement getUserAchievementById(int userAchievementId);
    List<UserAchievement> getUserAchievementsByUserId(int userId);
    void addUserAchievement(UserAchievement userAchievement);
    void updateUserAchievement(UserAchievement userAchievement);
    void deleteUserAchievement(UserAchievement userAchievement);
}
