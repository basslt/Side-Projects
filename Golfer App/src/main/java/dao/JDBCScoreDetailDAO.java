package dao;

import model.ScoreDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCScoreDetailDAO implements ScoreDetailDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";

    @Override
    public void createScoreDetail(ScoreDetail scoreDetail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO score_details (score_id, hole_id, score, putts, fairways_hit, gir) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, scoreDetail.getScoreId());
            stmt.setInt(2, scoreDetail.getHoleId());
            stmt.setInt(3, scoreDetail.getScore());
            stmt.setInt(4, scoreDetail.getPutts());
            stmt.setBoolean(5, scoreDetail.isFairwaysHit());
            stmt.setBoolean(6, scoreDetail.isGir());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ScoreDetail getScoreDetailById(int scoreDetailId) {
        ScoreDetail scoreDetail = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM score_details WHERE score_detail_id = ?")) {
            stmt.setInt(1, scoreDetailId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    scoreDetail = extractScoreDetailFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scoreDetail;
    }

    @Override
    public List<ScoreDetail> getScoreDetailsByScoreId(int scoreId) {
        List<ScoreDetail> scoreDetails = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM score_details WHERE score_id = ?")) {
            stmt.setInt(1, scoreId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ScoreDetail scoreDetail = extractScoreDetailFromResultSet(rs);
                    scoreDetails.add(scoreDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return scoreDetails;
    }

    @Override
    public void updateScoreDetail(ScoreDetail scoreDetail) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE score_details SET score = ?, putts = ?, fairways_hit = ?, gir = ? WHERE score_detail_id = ?")) {
            stmt.setInt(1, scoreDetail.getScore());
            stmt.setInt(2, scoreDetail.getPutts());
            stmt.setBoolean(3, scoreDetail.isFairwaysHit());
            stmt.setBoolean(4, scoreDetail.isGir());
            stmt.setInt(5, scoreDetail.getScoreDetailId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteScoreDetail(int scoreDetailId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM score_details WHERE score_detail_id = ?")) {
            stmt.setInt(1, scoreDetailId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ScoreDetail extractScoreDetailFromResultSet(ResultSet rs) throws SQLException {
        ScoreDetail scoreDetail = new ScoreDetail();
        scoreDetail.setScoreDetailId(rs.getInt("score_detail_id"));
        scoreDetail.setScoreId(rs.getInt("score_id"));
        scoreDetail.setHoleId(rs.getInt("hole_id"));
        scoreDetail.setScore(rs.getInt("score"));
        scoreDetail.setPutts(rs.getInt("putts"));
        scoreDetail.setFairwaysHit(rs.getBoolean("fairways_hit"));
        scoreDetail.setGir(rs.getBoolean("gir"));
        return scoreDetail;
    }
}
