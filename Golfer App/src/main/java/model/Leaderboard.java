package model;

public class Leaderboard {
    private int leaderboardId;
    private int tournamentId;
    private int userId;
    private int roundId;
    private int rank;

    public Leaderboard(int leaderboardId, int tournamentId, int userId, int roundId, int rank) {
        this.leaderboardId = leaderboardId;
        this.tournamentId = tournamentId;
        this.userId = userId;
        this.roundId = roundId;
        this.rank = rank;
    }

    public int getLeaderboardId() {
        return leaderboardId;
    }

    public void setLeaderboardId(int leaderboardId) {
        this.leaderboardId = leaderboardId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "leaderboardId=" + leaderboardId +
                ", tournamentId=" + tournamentId +
                ", userId=" + userId +
                ", roundId=" + roundId +
                ", rank=" + rank +
                '}';
    }
}
