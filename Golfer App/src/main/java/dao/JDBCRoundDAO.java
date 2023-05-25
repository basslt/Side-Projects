package dao;

import model.Round;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class JDBCRoundDAO implements RoundDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";

    @Override
    public List<Round> getRoundsByCourseId(int courseId) throws SQLException {
        List<Round> rounds = new ArrayList<>();
        String sql = "SELECT * FROM rounds WHERE course_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, courseId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Round round = extractRoundFromResultSet(rs);
                    rounds.add(round);
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Error retrieving rounds by course ID", ex);
        }
        return rounds;
    }

    @Override
    public void addRound(Round round) {
        try (Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO rounds (user_id, course_id, tee_box_id, score_id, date_played, weather_conditions, tee_time, tee_box_name, total_score, total_putts, total_fairways_hit, total_gir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, round.getUserId());
            stmt.setInt(2, round.getCourseId());
            stmt.setInt(3, round.getTeeBoxId());
            stmt.setInt(4, round.getScoreId());
            stmt.setDate(5, round.getDatePlayed());
            stmt.setString(6, round.getWeatherConditions());
            stmt.setTime(7, round.getTeeTime());
            stmt.setString(8, round.getTeeBoxName());
            stmt.setInt(9, round.getTotalScore());
            stmt.setInt(10, round.getTotalPutts());
            stmt.setInt(11, round.getTotalFairwaysHit());
            stmt.setInt(12, round.getTotalGir());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Round getRoundById(int roundId) {
        Round round = null;

        try (Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM rounds WHERE round_id = ?")) {
            stmt.setInt(1, roundId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    round = extractRoundFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return round;
    }

    @Override
    public List<Round> getRoundsByUserId(int userId) {
        List<Round> rounds = new ArrayList<>();

        try (Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM rounds WHERE user_id = ?")) {
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Round round = extractRoundFromResultSet(rs);
                    rounds.add(round);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rounds;
    }

    @Override
    public void updateRound(Round round) {
        try (Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE rounds SET user_id = ?, course_id = ?, tee_box_id = ?, score_id = ?, date_played = ?, weather_conditions = ?, tee_time = ?, tee_box_name = ?, total_score = ?, total_putts = ?, total_fairways_hit = ?, total_gir = ? WHERE round_id = ?")) {
            stmt.setInt(1, round.getUserId());
            stmt.setInt(2, round.getCourseId());
            stmt.setInt(3, round.getTeeBoxId());
            stmt.setInt(4, round.getScoreId());
            stmt.setDate(5, round.getDatePlayed());
            stmt.setString(6, round.getWeatherConditions());
            stmt.setTime(7, round.getTeeTime());
            stmt.setString(8, round.getTeeBoxName());
            stmt.setInt(9, round.getTotalScore());
            stmt.setInt(10, round.getTotalPutts());
            stmt.setInt(11, round.getTotalFairwaysHit());
            stmt.setInt(12, round.getTotalGir());
            stmt.setInt(13, round.getRoundId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRound(int roundId) {
        try (Connection conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM rounds WHERE round_id = ?")) {
            stmt.setInt(1, roundId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Round extractRoundFromResultSet(ResultSet rs) throws SQLException {
        Round round = new Round();
        round.setRoundId(rs.getInt("round_id"));
        round.setUserId(rs.getInt("user_id"));
        round.setCourseId(rs.getInt("course_id"));
        round.setTeeBoxId(rs.getInt("tee_box_id"));
        round.setScoreId(rs.getInt("score_id"));
        round.setDatePlayed(rs.getDate("date_played"));
        round.setWeatherConditions(rs.getString("weather_conditions"));
        round.setTeeTime(String.valueOf(rs.getTime("tee_time")));
        round.setTeeBoxName(rs.getString("tee_box_name"));
        round.setTotalScore(rs.getInt("total_score"));
        round.setTotalPutts(rs.getInt("total_putts"));
        round.setTotalFairwaysHit(rs.getInt("total_fairways_hit"));
        round.setTotalGir(rs.getInt("total_gir"));
        return round;
    }

}
