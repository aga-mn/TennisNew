package tennis.webservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import tennis.bo.Tournaments;
import tennis.exceptions.InvalidInputException;
import tennis.model.Tournament;
import tennis.service.TournamentService;

@WebService
public class TournamentWebServiceImpl implements TournamentWebService {

	@Autowired
	private TournamentService tournamentService;
	@Override
	@WebMethod(operationName="addTournament")
	public void addTournament(@WebParam(name="date") String date, @WebParam(name="location") String location,
			@WebParam(name="surface") String surface, @WebParam(name="draw") String draw, 
			@WebParam(name="numberOfSeeds") String numberOfSeeds) throws InvalidInputException {
		Tournament tournament = new Tournament();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tournamentDate;
		try {
			tournamentDate = format.parse(date);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		tournament.setTournamentDate(tournamentDate);
		tournament.setLocation(location);
		tournament.setSurface(surface);
		int seedsNumber = Integer.parseInt(numberOfSeeds);
		tournament.setNumberOfSeeds(seedsNumber);
		tournament.setSeeds(seedsNumber != 0);
		tournamentService.addTournament(tournament);
		

	}

	@Override
	@WebMethod(operationName="getAllTournaments")
	public Tournaments getAllTournaments() {
		List<Tournament> tournamentsFromDB = tournamentService.getAllTournaments();
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments; 
	}

	@Override
	@WebMethod(operationName="deleteTournament")
	public void deleteTournament(@WebParam(name="tournamentId")String tournamentId) {
		Tournament tournament = tournamentService.getTournament(Integer.parseInt(tournamentId));
		tournamentService.deleteTournament(tournament);

	}

	@Override
	public void modifyTournament(@WebParam(name="tournamentId")String tournamentId,
			@WebParam(name="date") String date, @WebParam(name="location") String location,
			@WebParam(name="surface") String surface, @WebParam(name="draw") String draw, 
			@WebParam(name="numberOfSeeds") String numberOfSeeds) throws InvalidInputException {
		Tournament tournament = tournamentService.getTournament(Integer.parseInt(tournamentId));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tournamentDate;
		try {
			tournamentDate = format.parse(date);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		tournament.setTournamentDate(tournamentDate);
	}

	@Override
	@WebMethod(operationName="getTournament")
	public Tournament getTournament(String tournamentId) {
		return tournamentService.getTournament(Integer.parseInt(tournamentId));
	}

	@Override
	@WebMethod(operationName="getAllTournamentsByDate")
	public Tournaments getAllTournamentsByDate(@WebParam(name="fromDate") String fromDate, 
			@WebParam(name="toDate") String toDate) throws InvalidInputException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tournamentStartDate;
		Date tournamentEndDate;
		try {
			tournamentStartDate = format.parse(fromDate);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		try {
			tournamentEndDate = format.parse(toDate);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		List<Tournament> tournamentsFromDB = 
				tournamentService.getAllTournamentsByDate(tournamentStartDate, tournamentEndDate);
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments;
	}

	@Override
	@WebMethod(operationName="getAllTournamentsByLocation")
	public Tournaments getAllTournamentsByLocation(@WebParam(name="location") String location) {
		List<Tournament> tournamentsFromDB = tournamentService.getAllTournamentsByLocation(location);
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments;
	}

	@Override
	@WebMethod(operationName="getTournamentsByLocationAndDate")
	public Tournaments getAllTournamentsByLocationAndDate(@WebParam(name="location") String location,
			@WebParam(name="dateFrom") String dateFrom, @WebParam(name="dateTo")String dateTo) 
					throws InvalidInputException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tournamentStartDate;
		Date tournamentEndDate;
		try {
			tournamentStartDate = format.parse(dateFrom);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		try {
			tournamentEndDate = format.parse(dateTo);
		} catch (ParseException e) {
			throw new InvalidInputException(e.getMessage(), "Invalid date format");
		}
		List<Tournament> tournamentsFromDB = tournamentService.getAllTournamentsByLocationAndDate
				(location, tournamentStartDate, tournamentEndDate);
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments;
	}

	@Override
	@WebMethod(operationName="getActiveTournaments")
	public Tournaments getAllActiveTournaments() {
		List<Tournament> tournamentsFromDB = tournamentService.getAllActiveTournaments();
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments;
	}

	@Override
	@WebMethod(operationName="getActiveTournamentsByLocation")
	public Tournaments getAllActiveTournamentsByLocation(@WebParam(name="location")String location) {
		List<Tournament> tournamentsFromDB = tournamentService.getAllActiveTournamentsByLocation(location);
		Tournaments tournaments = new Tournaments();
		tournaments.setTournaments(tournamentsFromDB);
		return tournaments;
	}

}
