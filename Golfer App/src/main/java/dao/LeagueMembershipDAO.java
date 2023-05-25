package dao;

import model.LeagueMembership;

import java.util.List;

public interface LeagueMembershipDAO {
    LeagueMembership getMembershipById(int membershipId);
    List<LeagueMembership> getMembershipsByUserId(int userId);
    List<LeagueMembership> getMembershipsByLeagueId(int leagueId);
    void addMembership(LeagueMembership membership);
    void updateMembership(LeagueMembership membership);
    void deleteMembership(LeagueMembership membership);
}