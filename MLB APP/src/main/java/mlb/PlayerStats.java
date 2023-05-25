package mlb;

public class PlayerStats {
    private String playerName;
    private int hits;
    private int runs;
    private int homeRuns;
    private int rbis;
    private int stolenBases;



    public PlayerStats(String playerName, int hits, int runs, int homeRuns, int rbis, int stolenBases) {
        this.playerName = playerName;
        this.hits = hits;
        this.runs = runs;
        this.homeRuns = homeRuns;
        this.rbis = rbis;
        this.stolenBases = stolenBases;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getRbis() {
        return rbis;
    }

    public void setRbis(int rbis) {
        this.rbis = rbis;
    }

    public int getStolenBases() {
        return stolenBases;
    }

    public void setStolenBases(int stolenBases) {
        this.stolenBases = stolenBases;
    }


    @Override
    public String toString() {
        return "Hits: " + hits + ", Runs: " + runs + ", Home Runs: " + homeRuns
                + ", RBIs: " + rbis + ", Stolen Bases: " + stolenBases;
    }
}


