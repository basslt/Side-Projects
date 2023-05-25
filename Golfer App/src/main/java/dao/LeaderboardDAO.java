package dao;

import model.Leaderboard;

import java.util.List;

public interface LeaderboardDAO {
    Leaderboard getLeaderboardById(int leaderboardId);
    List<Leaderboard> getLeaderboardsByTournamentId(int tournamentId);
    void addLeaderboard(Leaderboard leaderboard);
    void updateLeaderboard(Leaderboard leaderboard);
    void deleteLeaderboard(Leaderboard leaderboard);
}