package tennis.dao;

import tennis.model.Club;
import tennis.model.Tournament;

import java.util.Date;
import java.util.List;

/**
 * Created by amolda on 30.11.14.
 */
public interface ClubDao {

    void addClub(Club club);
    List<Club> getAllClubs();
    void deleteClub(Club club);
    void modifyClub(Club club);
    Club getClub(int clubId);
    List<Tournament> getTournamentsByClubAndDate(int clubId, Date fromDate,Date toDate);
    //List<Tournament> getAllTournamentsByClub(int clubId);

}
