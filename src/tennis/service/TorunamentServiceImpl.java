package tennis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tennis.dao.TournamentDao;
import tennis.model.Tournament;

@Service
@Transactional //(propagation=Propagation.SUPPORTS, readOnly=true)
public class TorunamentServiceImpl implements TournamentService {
	
	@Autowired
    private TournamentDao tournamentDao;
    @Override
    public void addTournament(Tournament tournament) {
        if (tournament == null) {
            System.out.println("null");
        } else {
            tournamentDao.addTournament(tournament);
        }
    }

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentDao.getAllTournaments();
    }


    @Override
    public void deleteTournament(Tournament tournament) {
        tournamentDao.deleteTournament(tournament);
    }

    @Override
    public void modifyTournament(Tournament tournament) {
        tournamentDao.modifyTournament(tournament);
    }

    @Override
    public Tournament getTournament(int tournamentId) {
        return tournamentDao.getTournament(tournamentId);
    }

    @Override
    public List<Tournament> getAllTournamentsByDate(Date fromDate, Date toDate) {
        return tournamentDao.getAllTournamentsByDate(fromDate, toDate);
    }

    @Override
    public List<Tournament> getAllTournamentsByLocation(String location) {
        return tournamentDao.getAllTournamentsByLocation(location);
    }

    @Override
    public List<Tournament> getAllTournamentsByLocationAndDate(String location, Date dateFrom, Date dateTo) {
        return tournamentDao.getAllTournamentsByLocationAndDate(location, dateFrom, dateTo);
    }

    @Override
    public List<Tournament> getAllActiveTournaments() {
        return tournamentDao.getAllActiveTournaments();
    }

    @Override
    public List<Tournament> getAllActiveTournamentsByLocation(String location) {
        return tournamentDao.getAllActiveTournamentsByLocation(location);
    }

}
