package tennis.webservice;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tennis.bo.Tournaments;
import tennis.exceptions.InvalidInputException;
import tennis.model.Tournament;

public interface TournamentWebService {
	
    void addTournament(String date, String location, String surface, String draw, String numberOfSeeds) throws InvalidInputException;
    Tournaments getAllTournaments();
    //pobieranie wszystkich turniejów po lokalizaji
    Tournaments getAllTournamentsByLocation(String location);
    //pobieranie wszystkich otwartych turniejów (data >= dziś)
    Tournaments getAllActiveTournaments();
    //pobieranie wszystkich otwartych tuurniejów po lokalizacji
    Tournaments getAllActiveTournamentsByLocation(String location);
	void deleteTournament(String tournamentId);
	void modifyTournament(String tournamentId, String date, String location,
			String surface, String draw, String numberOfSeeds) throws InvalidInputException;
	Tournament getTournament(String tournamentId);
	Tournaments getAllTournamentsByDate(String fromDate, String toDate) throws InvalidInputException;
	Tournaments getAllTournamentsByLocationAndDate(String location,
			String dateFrom, String dateTo) throws InvalidInputException;

}