package dao;

import model.Tournament;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTournamentDAO implements TournamentDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Golfer";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres1";


    @Override
    public Tournament getTournamentByName(String tournamentName) {
        String query = "SELECT * FROM tournaments WHERE tournament_name = ?";
        Tournament tournament = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tournamentName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tournament = extractTournamentFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournament;
    }

    @Override
    public List<Tournament> getTournamentsByDate(Date date) {
        String query = "SELECT * FROM tournaments WHERE date = ?";
        List<Tournament> tournaments = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, java.sql.Date.valueOf(String.valueOf(date)));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tournament tournament = extractTournamentFromResultSet(rs);
                tournaments.add(tournament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournaments;
    }

    @Override
    public List<Tournament> getTournamentsByLocation(String location) {
        String query = "SELECT * FROM tournaments WHERE location = ?";
        List<Tournament> tournaments = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, location);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tournament tournament = extractTournamentFromResultSet(rs);
                tournaments.add(tournament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournaments;
    }

    @Override
    public List<Tournament> getTournamentsByFee(BigDecimal fee) {
        String query = "SELECT * FROM tournaments WHERE fee = ?";
        List<Tournament> tournaments = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBigDecimal(1, fee);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tournament tournament = extractTournamentFromResultSet(rs);
                tournaments.add(tournament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournaments;
    }
    @Override
    public void createTournament(Tournament tournament) {
        String query = "INSERT INTO tournaments (tournament_name, date, location, registration_info, rules, fee, organizer_user_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tournament.getTournamentName());
            stmt.setDate(2, tournament.getDate());
            stmt.setString(3, tournament.getLocation());
            stmt.setString(4, tournament.getRegistrationInfo());
            stmt.setString(5, tournament.getRules());
            stmt.setBigDecimal(6, tournament.getFee());
            stmt.setInt(7, tournament.getOrganizerUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tournament getTournamentById(int tournamentId) {
        String query = "SELECT * FROM tournaments WHERE tournament_id = ?";
        Tournament tournament = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tournamentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tournament = extractTournamentFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournament;
    }

    @Override
    public List<Tournament> getAllTournaments() {
        String query = "SELECT * FROM tournaments";
        List<Tournament> tournaments = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Tournament tournament = extractTournamentFromResultSet(rs);
                tournaments.add(tournament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tournaments;
    }

    @Override
    public void updateTournament(Tournament tournament) {
        String query = "UPDATE tournaments SET tournament_name = ?, date = ?, location = ?, registration_info = ?, " +
                "rules = ?, fee = ?, organizer_user_id = ? WHERE tournament_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tournament.getTournamentName());
            stmt.setDate(2, tournament.getDate());
            stmt.setString(3, tournament.getLocation());
            stmt.setString(4, tournament.getRegistrationInfo());
            stmt.setString(5, tournament.getRules());
            stmt.setBigDecimal(6, tournament.getFee());
            stmt.setInt(7, tournament.getOrganizerUserId());
            stmt.setInt(8, tournament.getTournamentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTournament(int tournamentId) {
        String query = "DELETE FROM tournaments WHERE tournament_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, tournamentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Tournament extractTournamentFromResultSet(ResultSet rs) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setTournamentId(rs.getInt("tournament_id"));
        tournament.setTournamentName(rs.getString("tournament_name"));
        tournament.setDate(Date.valueOf(rs.getDate("date").toLocalDate()));
        tournament.setLocation(rs.getString("location"));
        tournament.setRegistrationInfo(rs.getString("registration_info"));
        tournament.setRules(rs.getString("rules"));
        tournament.setFee(rs.getBigDecimal("fee"));
        tournament.setOrganizerUserId(rs.getInt("organizer_user_id"));
        return tournament;
    }
}

