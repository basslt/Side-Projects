package dao;

import model.Scores;

import java.sql.Date;
import java.util.List;

public interface ScoresDAO {
    Scores getScoreById(int scoreId);
    List<Scores> getScoresByUserId(int userId);
    void addScore(Scores score);
    void updateScore(Scores score);


    void deleteScore(int scoreId);

    int getTotalScoreByUsername(String username);

    int getTotalPuttsByUsername(String username);

    int getTotalFairwaysHitByUsername(String username);

    int getTotalGirByUsername(String username);

    int getTotalScoreByCourseName(String courseName);

    List<Scores> getScoreByDatePlayed(Date datePlayed);

    int getParByHoleNumber(int courseId, int holeNumber);

    int getDistanceByHoleNumber(int courseId, int holeNumber);

    String getHazardByHoleNumber(int courseId, int holeNumber);
}
