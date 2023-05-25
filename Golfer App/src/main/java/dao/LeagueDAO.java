package dao;

import model.League;

import java.util.List;

public interface LeagueDAO {
    League getLeagueById(int leagueId);

    List<League> getAllLeagues();

    void addLeague(League league);

    void updateLeague(League league);

    void deleteLeague(League league);
}