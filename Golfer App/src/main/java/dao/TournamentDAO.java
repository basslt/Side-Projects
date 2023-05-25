package dao;

import model.Tournament;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface TournamentDAO {
    Tournament getTournamentByName(String tournamentName);

    List<Tournament> getTournamentsByDate(Date date);

    List<Tournament> getTournamentsByLocation(String location);

    List<Tournament> getTournamentsByFee(BigDecimal fee);

    void createTournament(Tournament tournament);

    Tournament getTournamentById(int tournamentId);
    List<Tournament> getAllTournaments();


    void updateTournament(Tournament tournament);


    void deleteTournament(int tournamentId);
}

