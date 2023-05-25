package model;

public class ScoreDetail {
    private int scoreDetailId;
    private int scoreId;
    private int holeId;
    private int score;
    private int putts;
    private boolean fairwaysHit;
    private boolean gir;

    public ScoreDetail(int scoreDetailId, int scoreId, int holeId, int score, int putts, boolean fairwaysHit, boolean gir) {
        this.scoreDetailId = scoreDetailId;
        this.scoreId = scoreId;
        this.holeId = holeId;
        this.score = score;
        this.putts = putts;
        this.fairwaysHit = fairwaysHit;
        this.gir = gir;
    }

    public ScoreDetail() {

    }

    public int getScoreDetailId() {
        return scoreDetailId;
    }

    public void setScoreDetailId(int scoreDetailId) {
        this.scoreDetailId = scoreDetailId;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getHoleId() {
        return holeId;
    }

    public void setHoleId(int holeId) {
        this.holeId = holeId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPutts() {
        return putts;
    }

    public void setPutts(int putts) {
        this.putts = putts;
    }

    public boolean isFairwaysHit() {
        return fairwaysHit;
    }

    public void setFairwaysHit(boolean fairwaysHit) {
        this.fairwaysHit = fairwaysHit;
    }

    public boolean isGir() {
        return gir;
    }

    public void setGir(boolean gir) {
        this.gir = gir;
    }

    @Override
    public String toString() {
        return "ScoreDetail{" +
                "scoreDetailId=" + scoreDetailId +
                ", scoreId=" + scoreId +
                ", holeId=" + holeId +
                ", score=" + score +
                ", putts=" + putts +
                ", fairwaysHit=" + fairwaysHit +
                ", gir=" + gir +
                '}';
    }
}
