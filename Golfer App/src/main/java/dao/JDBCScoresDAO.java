package dao;


import model.ScoreDetail;
import model.Scores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCScoresDAO implements ScoresDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";

    @Override
    public Scores getScoreById(int scoreId) {
        String query = "SELECT * FROM scores WHERE score_id = ?";
        Scores score = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, scoreId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                score = extractScoreFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return score;
    }

    @Override
    public List<Scores> getScoresByUserId(int userId) {
        String query = "SELECT * FROM scores WHERE user_id = ?";
        List<Scores> scores = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Scores score = extractScoreFromResultSet(rs);
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scores;
    }

    @Override
    public void addScore(Scores score) {
        String insertScoreQuery = "INSERT INTO scores (user_id, course_id, date_played, total_score, total_putts, total_fairways_hit, total_gir) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertScoreDetailQuery = "INSERT INTO score_details (score_id, hole_id, score, putts, fairways_hit, gir) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmtScore = conn.prepareStatement(insertScoreQuery, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtScoreDetail = conn.prepareStatement(insertScoreDetailQuery)) {
            conn.setAutoCommit(false);

            // Insert score
            stmtScore.setInt(1, score.getUserId());
            stmtScore.setInt(2, score.getCourseId());
            stmtScore.setDate(3, java.sql.Date.valueOf(score.getDatePlayed()));
            stmtScore.setInt(4, score.getTotalScore());
            stmtScore.setInt(5, score.getTotalPutts());
            stmtScore.setInt(6, score.getTotalFairwaysHit());
            stmtScore.setInt(7, score.getTotalGir());
            stmtScore.executeUpdate();

            // Get the generated score ID
            ResultSet generatedKeys = stmtScore.getGeneratedKeys();
            int scoreId = -1;
            if (generatedKeys.next()) {
                scoreId = generatedKeys.getInt(1);
            }

            // Insert score details
            for (ScoreDetail scoreDetail : score.getScoreDetails()) {
                stmtScoreDetail.setInt(1, scoreId);
                stmtScoreDetail.setInt(2, scoreDetail.getHoleId());
                stmtScoreDetail.setInt(3, scoreDetail.getScore());
                stmtScoreDetail.setInt(4, scoreDetail.getPutts());
                stmtScoreDetail.setBoolean(5, scoreDetail.isFairwaysHit());
                stmtScoreDetail.setBoolean(6, scoreDetail.isGir());
                stmtScoreDetail.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteScore(int scoreId) {
        String deleteScoreQuery = "DELETE FROM scores WHERE score_id = ?";
        String deleteScoreDetailsQuery = "DELETE FROM score_details WHERE score_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmtScore = conn.prepareStatement(deleteScoreQuery);
             PreparedStatement stmtScoreDetails = conn.prepareStatement(deleteScoreDetailsQuery)) {
            conn.setAutoCommit(false);

            // Delete score details
            stmtScoreDetails.setInt(1, scoreId);
            stmtScoreDetails.executeUpdate();

            // Delete score
            stmtScore.setInt(1, scoreId);
            stmtScore.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateScore(Scores score) {
        String updateScoreQuery = "UPDATE scores SET user_id = ?, course_id = ?, date_played = ?, " +
                "total_score = ?, total_putts = ?, total_fairways_hit = ?, total_gir = ? WHERE score_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmtScore = conn.prepareStatement(updateScoreQuery)) {
            stmtScore.setInt(1, score.getUserId());
            stmtScore.setInt(2, score.getCourseId());
            stmtScore.setDate(3, java.sql.Date.valueOf(score.getDatePlayed()));
            stmtScore.setInt(4, score.getTotalScore());
            stmtScore.setInt(5, score.getTotalPutts());
            stmtScore.setInt(6, score.getTotalFairwaysHit());
            stmtScore.setInt(7, score.getTotalGir());
            stmtScore.setInt(8, score.getScoreId());
            stmtScore.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTotalScoreByUsername(String username) {
        String query = "SELECT SUM(total_score) AS total FROM scores INNER JOIN users ON scores.user_id = users.user_id WHERE users.username = ?";
        int totalScore = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalScore = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalScore;
    }

    @Override
    public int getTotalPuttsByUsername(String username) {
        String query = "SELECT SUM(total_putts) AS total FROM scores INNER JOIN users ON scores.user_id = users.user_id WHERE users.username = ?";
        int totalPutts = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalPutts = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalPutts;
    }

    @Override
    public int getTotalFairwaysHitByUsername(String username) {
        String query = "SELECT SUM(totalFairwaysHit) AS total FROM scores INNER JOIN users ON scores.user_id = users.user_id WHERE users.username = ?";
        int totalFairwaysHit = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalFairwaysHit = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalFairwaysHit;
    }

    @Override
    public int getTotalGirByUsername(String username) {
        String query = "SELECT SUM(totalGir) AS total FROM scores INNER JOIN users ON scores.user_id = users.user_id WHERE users.username = ?";
        int totalGir = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalGir = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalGir;
    }

    @Override
    public int getTotalScoreByCourseName(String courseName) {
        String query = "SELECT SUM(total_score) AS total FROM scores INNER JOIN courses ON scores.course_id = courses.course_id WHERE courses.course_name = ?";
        int totalScore = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalScore = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalScore;
    }
    @Override
    public List<Scores> getScoreByDatePlayed(Date datePlayed) {
        List<Scores> scores = new ArrayList<>();
        String query = "SELECT * FROM scores WHERE date_played = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, Date.valueOf(String.valueOf(datePlayed)));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Scores score = extractScoreFromResultSet(rs);
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return scores;
    }
    @Override
    public int getParByHoleNumber(int courseId, int holeNumber) {
        int par = 0;
        String query = "SELECT par FROM holes WHERE course_id = ? AND hole_number = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, courseId);
            statement.setInt(2, holeNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                par = rs.getInt("par");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }

        return par;
    }

    @Override
    public int getDistanceByHoleNumber(int courseId, int holeNumber) {
        int distance = 0;
        String query = "SELECT distance FROM holes WHERE course_id = ? AND hole_number = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, courseId);
            statement.setInt(2, holeNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                distance = rs.getInt("distance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }

        return distance;
    }

    @Override
    public String getHazardByHoleNumber(int courseId, int holeNumber) {
        String hazard = "";
        String query = "SELECT hazard FROM holes WHERE course_id = ? AND hole_number = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, courseId);
            statement.setInt(2, holeNumber);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                hazard = rs.getString("hazard");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }

        return hazard;
    }


    private Scores extractScoreFromResultSet(ResultSet rs) throws SQLException {
        Scores score = new Scores();
        score.setScoreId(rs.getInt("score_id"));
        score.setUserId(rs.getInt("user_id"));
        score.setCourseId(rs.getInt("course_id"));
        score.setDatePlayed(rs.getDate("date_played").toLocalDate());
        score.setTotalScore(rs.getInt("total_score"));
        score.setTotalPutts(rs.getInt("total_putts"));
        score.setTotalFairwaysHit(rs.getInt("total_fairways_hit"));
        score.setTotalGir(rs.getInt("total_gir"));
        return score;
    }


}
