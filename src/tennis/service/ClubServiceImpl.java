package tennis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tennis.dao.ClubDao;
import tennis.model.Club;
import tennis.model.Tournament;

@Service
@Transactional //(propagation=Propagation.SUPPORTS, readOnly=true)
public class ClubServiceImpl implements ClubService {


    @Autowired
    private ClubDao clubDao;

    public void addClub(Club club) {
        clubDao.addClub(club);
    }

    public List<Club> getAllClubs() {
        return clubDao.getAllClubs();
    }

    public void deleteClub(Club club) {
        clubDao.deleteClub(club);
    }

    public void modifyClub(Club club) {
        clubDao.modifyClub(club);
    }

    public Club getClub(int clubId) {
        return clubDao.getClub(clubId);
    }

    @Override
    public List<Tournament> getTournamentsByClubAndDate(int clubId, Date fromDate, Date toDate) {
        return clubDao.getTournamentsByClubAndDate(clubId, fromDate, toDate);
    }

}
