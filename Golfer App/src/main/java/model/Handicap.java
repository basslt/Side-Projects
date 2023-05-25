package model;

import java.util.Date;

public class Handicap {
    private int handicapId;
    private int userId;
    private double handicapIndex;
    private Date revisionDate;


    public Handicap(int handicapId, int userId, double handicapIndex, Date revisionDate) {
        this.handicapId = handicapId;
        this.userId = userId;
        this.handicapIndex = handicapIndex;
        this.revisionDate = revisionDate;
    }

    public int getHandicapId() {
        return handicapId;
    }

    public void setHandicapId(int handicapId) {
        this.handicapId = handicapId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getHandicapIndex() {
        return handicapIndex;
    }

    public void setHandicapIndex(double handicapIndex) {
        this.handicapIndex = handicapIndex;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    @Override
    public String toString() {
        return "Handicap{" +
                "handicapId=" + handicapId +
                ", userId=" + userId +
                ", handicapIndex=" + handicapIndex +
                ", revisionDate=" + revisionDate +
                '}';
    }
}
