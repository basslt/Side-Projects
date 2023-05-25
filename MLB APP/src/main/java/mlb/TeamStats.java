package mlb;

public class TeamStats {
    private String teamName;
    private int wins;
    private int losses;
    private double winningPercentage;
    private int gamesBack;
    private int runsScored;
    private int runsAllowed;

    public TeamStats(String teamName, int wins, int losses, double winningPercentage, int gamesBack, int runsScored, int runsAllowed) {
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
        this.winningPercentage = winningPercentage;
        this.gamesBack = gamesBack;
        this.runsScored = runsScored;
        this.runsAllowed = runsAllowed;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWinningPercentage() {
        return winningPercentage;
    }

    public void setWinningPercentage(double winningPercentage) {
        this.winningPercentage = winningPercentage;
    }

    public int getGamesBack() {
        return gamesBack;
    }

    public void setGamesBack(int gamesBack) {
        this.gamesBack = gamesBack;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getRunsAllowed() {
        return runsAllowed;
    }

    public void setRunsAllowed(int runsAllowed) {
        this.runsAllowed = runsAllowed;
    }

    @Override
    public String toString() {
        return "TeamStats{" +
                "wins=" + wins +
                ", losses=" + losses +
                ", winningPercentage=" + winningPercentage +
                ", gamesBack=" + gamesBack +
                ", runsScored=" + runsScored +
                ", runsAllowed=" + runsAllowed +
                '}';
    }
}
