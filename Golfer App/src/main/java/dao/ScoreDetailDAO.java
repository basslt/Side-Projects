package dao;

import model.ScoreDetail;

import java.util.List;

public interface ScoreDetailDAO {
    void createScoreDetail(ScoreDetail scoreDetail);
    ScoreDetail getScoreDetailById(int scoreDetailId);
    List<ScoreDetail> getScoreDetailsByScoreId(int scoreId);
    void updateScoreDetail(ScoreDetail scoreDetail);

    void deleteScoreDetail(int scoreDetailId);
}