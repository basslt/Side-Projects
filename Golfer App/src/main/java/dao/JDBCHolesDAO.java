package dao;

import model.Holes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCHolesDAO implements HolesDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";

    @Override
    public void createHole(Holes hole) {
        String query = "INSERT INTO holes (course_id, hole_number, par, distance) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, hole.getCourseId());
            statement.setInt(2, hole.getHoleNumber());
            statement.setInt(3, hole.getPar());
            statement.setInt(4, hole.getDistance());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }
    }

    @Override
    public Holes getHoleById(int holeId) {
        Holes hole = null;
        String query = "SELECT * FROM holes WHERE hole_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, holeId);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                hole = extractHoleFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }

        return hole;
    }

    @Override
    public List<Holes> getHolesByCourseId(int courseId) {
        List<Holes> holes = new ArrayList<>();
        String query = "SELECT * FROM holes WHERE course_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, courseId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Holes hole = extractHoleFromResultSet(rs);
                holes.add(hole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }

        return holes;
    }

    @Override
    public void updateHole(Holes hole) {
        String query = "UPDATE holes SET course_id = ?, hole_number = ?, par = ?, distance = ? WHERE hole_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, hole.getCourseId());
            statement.setInt(2, hole.getHoleNumber());
            statement.setInt(3, hole.getPar());
            statement.setInt(4, hole.getDistance());
            statement.setInt(5, hole.getHoleId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential exceptions appropriately
        }
    }

    @Override
    public void deleteHole(int holeId) {
        String query = "DELETE FROM holes WHERE hole_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, holeId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private Holes extractHoleFromResultSet(ResultSet rs) throws SQLException {
        Holes hole = new Holes();
        hole.setHoleId(rs.getInt("hole_id"));
        hole.setCourseId(rs.getInt("course_id"));
        hole.setHoleNumber(rs.getInt("hole_number"));
        hole.setPar(rs.getInt("par"));
        hole.setDistance(rs.getInt("distance"));
        return hole;
    }
}
