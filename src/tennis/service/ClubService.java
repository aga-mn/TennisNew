package tennis.service;

import java.util.Date;
import java.util.List;

import tennis.model.Club;
import tennis.model.Tournament;

public interface ClubService {
	
    void addClub(Club club);
    List<Club> getAllClubs();
    void deleteClub(Club club);
    void modifyClub(Club club);
    Club getClub(int clubId);
    List<Tournament> getTournamentsByClubAndDate(int clubId, Date fromDate, Date toDate);
    //List<Tournament> getAllTournamentsByClub(int clubId);

}
