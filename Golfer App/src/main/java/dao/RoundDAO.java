package dao;

import model.Round;

import java.sql.SQLException;
import java.util.List;

public interface RoundDAO {
    Round getRoundById(int roundId);
    List<Round> getRoundsByUserId(int userId);


    List<Round> getRoundsByCourseId(int courseId) throws SQLException;

    void addRound(Round round);
    void updateRound(Round round);


    void deleteRound(int roundId);
}
