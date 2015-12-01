package tennis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tennis.model.Match;


@Repository
public class MatchDaoImpl implements MatchDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addMatch(Match match) {
        sessionFactory.getCurrentSession().save(match);
    }

    @SuppressWarnings("unchecked")
	public List<Match> getAllMatches() {
        return sessionFactory.getCurrentSession().createQuery("from Match").
                list();
    }

    public void deleteMatch(Match match) {

        sessionFactory.getCurrentSession().delete(match);
    }

    public void modifyMatch(Match match) {

        sessionFactory.getCurrentSession().update(match);
    }

    public Match getMatch(String matchId) {

        return (Match) sessionFactory.getCurrentSession().get(Match.class, Integer.parseInt(matchId));
    }

	public List<Match> getMatchesByPlayer(String playerId) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Match where player1 = :playerId");
		query.setParameter("playerId", playerId);
		return query.list();
		
	}

	public List<Match> getMatchesByTwoPlayers(String firstPlayerId,
			String secondPlayerId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Match where (player1 = :firstPlayerId and player2 = :secondPlayerId) "
				+ " or (player1 = :secondPlayerId and player2 = :firstPlayerId)");
		query.setParameter("firstPlayerId", firstPlayerId);
		query.setParameter("secondPlayerId", secondPlayerId);
		return query.list();
	}

}
