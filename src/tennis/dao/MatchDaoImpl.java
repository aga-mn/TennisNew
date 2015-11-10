package tennis.dao;

import java.util.List;

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

    public Match getMatch(int matchId) {

        return (Match) sessionFactory.getCurrentSession().get(Match.class, matchId);
    }
}
