package tennis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tennis.dao.MatchDao;
import tennis.model.Match;


@Service
@Transactional //(propagation=Propagation.SUPPORTS, readOnly=true)
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    public void addMatch(Match match) {
        matchDao.addMatch(match);
    }

    public List<Match> getAllMatches() {
        return matchDao.getAllMatches();
    }

    public void deleteMatch(Match match) {
        matchDao.deleteMatch(match);
    }

    public void modifyMatch(Match match) {
        matchDao.modifyMatch(match);
    }

    public Match getMatch(String matchId) {
        return matchDao.getMatch(matchId);
    }

	@Override
	public List<Match> getMatchesByPlayer(String playerId) {
		return matchDao.getMatchesByPlayer(playerId);
	}

	@Override
	public List<Match> getMatchesByTwoPlayers(String firstPlayerId,
			String secondPlayerId) {
		return matchDao.getMatchesByTwoPlayers(firstPlayerId, secondPlayerId);
	}

}
