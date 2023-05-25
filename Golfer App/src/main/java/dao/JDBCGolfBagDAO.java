package dao;

import model.GolfBag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCGolfBagDAO implements GolfBagDAO {

    private Connection getConnection() throws SQLException {
        // Assuming you have a method to establish a database connection, replace the code below with your implementation
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Golfer", "postgres", "postgres1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private GolfBag extractGolfBagFromResultSet(ResultSet rs) throws SQLException {
        GolfBag golfBag = new GolfBag();
        golfBag.setBagId(bagId);
        golfBag.setGolferId(golferId);
        golfBag.setClubName(clubName);
        golfBag.setBrand(brand);
        golfBag.setClubType(clubType);
        golfBag.setLoft(loft);
        golfBag.setShaftFlex(shaftFlex);
        golfBag.setGrip(grip);
        golfBag.setBalls(balls);
        golfBag.setGlove(glove);
        golfBag.setRangFinder(rangFinder);

        return golfBag;

}
    @Override
    public void addGolfBag(GolfBag golfBag) {
        String sql = "INSERT INTO golf_bags (golfer_id, club_name, brand, club_type, loft, shaft_flex, grip, balls, glove, rang_finder) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, golfBag.getGolferId());
            statement.setString(2, golfBag.getClubName());
            statement.setString(3, golfBag.getBrand());
            statement.setString(4, golfBag.getClubType());
            statement.setInt(5, golfBag.getLoft());
            statement.setString(6, golfBag.getShaftFlex());
            statement.setString(7, golfBag.getGrip());
            statement.setString(8, golfBag.getBalls());
            statement.setString(9, golfBag.getGlove());
            statement.setString(10, golfBag.getRangFinder());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateGolfBag(GolfBag golfBag) {
        String sql = "UPDATE golf_bags SET club_name = ?, brand = ?, club_type = ?, loft = ?, shaft_flex = ?, " +
                "grip = ?, balls = ?, glove = ?, rang_finder = ? WHERE bag_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, golfBag.getClubName());
            statement.setString(2, golfBag.getBrand());
            statement.setString(3, golfBag.getClubType());
            statement.setInt(4, golfBag.getLoft());
            statement.setString(5, golfBag.getShaftFlex());
            statement.setString(6, golfBag.getGrip());
            statement.setString(7, golfBag.getBalls());
            statement.setString(8, golfBag.getGlove());
            statement.setString(9, golfBag.getRangFinder());
            statement.setInt(10, golfBag.getBagId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



    @Override
    public void deleteGolfBag(int bagId) {
        String sql = "DELETE FROM golf_bags WHERE bag_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bagId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public GolfBag getGolfBagById(int bagId) {
        GolfBag golfBag = null;
        String sql = "SELECT * FROM golf_bags WHERE bag_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bagId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    golfBag = extractGolfBagFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return golfBag;
    }



    @Override
    public List<GolfBag> getGolfBagsByGolfer(int golferId) {
        List<GolfBag> golfBags = new ArrayList<>();
        String sql = "SELECT * FROM golf_bags WHERE golfer_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, golferId);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    GolfBag golfBag = extractGolfBagFromResultSet(rs);
                    golfBags.add(golfBag);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return golfBags;
    }
    public GolfBag getGolfBagByUserId(int userId) {
        String sql = "SELECT * FROM golf_bags WHERE golfer_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return extractGolfBagFromResultSet(rs);
                } else {
                    return null; // No golf bag found for the user ID
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving golf bag by user ID: " + e.getMessage());
            return null;
        }
    }

}
