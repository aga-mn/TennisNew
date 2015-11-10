package tennis.dao;

import java.util.Date;
import java.util.List;

import tennis.model.Tournament;

public interface TournamentDao {
	
    //dodawanie turnieju
    void addTournament(Tournament tournament);
    //pobieranie wszystkich turniejów
    List<Tournament> getAllTournaments();
    //pobieranie wszystkich turniejów z zakresu dat
    List<Tournament> getAllTournamentsByDate(Date fromDate, Date toDate);
    //usuwanie turnieju
    void deleteTournament(Tournament tournament);
    //modyfikacja/edycja turnieju
    void modifyTournament(Tournament tournament);
    //pobranie turnieju
    Tournament getTournament(int tournamentId);
    //pobieranie wszystkich turniejów po lokalizaji
    List<Tournament> getAllTournamentsByLocation(String location);
    //pobieranie wszystkich turniejów po lokalizacji i datach
    List<Tournament> getAllTournamentsByLocationAndDate(String location, Date dateFrom, Date dateTo);
    //pobieranie wszystkich otwartych turniejów (data >= dziś)
    List<Tournament> getAllActiveTournaments();
    //pobieranie wszystkich otwartych tuurniejów po lokalizacji
    List<Tournament> getAllActiveTournamentsByLocation(String location);

}
