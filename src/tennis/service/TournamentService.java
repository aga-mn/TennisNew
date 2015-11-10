package tennis.service;

import java.util.Date;
import java.util.List;

import tennis.model.Tournament;

public interface TournamentService {	

    void addTournament(Tournament tournament);
    List<Tournament> getAllTournaments();
    void deleteTournament(Tournament tournament);
    void modifyTournament(Tournament tournament);
    Tournament getTournament(int tournamentId);
    List<Tournament> getAllTournamentsByDate(Date fromDate, Date toDate);
    //pobieranie wszystkich turniejów po lokalizaji
    List<Tournament> getAllTournamentsByLocation(String location);
    //pobieranie wszystkich turniejów po lokalizacji i datach
    List<Tournament> getAllTournamentsByLocationAndDate(String location, Date dateFrom, Date dateTo);
    //pobieranie wszystkich otwartych turniejów (data >= dziś)
    List<Tournament> getAllActiveTournaments();
    //pobieranie wszystkich otwartych tuurniejów po lokalizacji
    List<Tournament> getAllActiveTournamentsByLocation(String location);

}
