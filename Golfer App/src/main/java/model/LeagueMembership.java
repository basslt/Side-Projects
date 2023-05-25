package model;

public class LeagueMembership {
    private int membershipId;
    private int leagueId;
    private int userId;

    public LeagueMembership(int membershipId, int leagueId, int userId) {
        this.membershipId = membershipId;
        this.leagueId = leagueId;
        this.userId = userId;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LeagueMembership{" +
                "membershipId=" + membershipId +
                ", leagueId=" + leagueId +
                ", userId=" + userId +
                '}';
    }
}

