package tennis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tennis.model.PlayerRanking;

@Repository
public class PlayerRankingDaoImpl implements PlayerRankingDao {
	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRanking(PlayerRanking ranking) {
        sessionFactory.getCurrentSession().save(ranking);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<PlayerRanking> getAllRankings() {
        return sessionFactory.getCurrentSession().
                createQuery("from PlayerRanking").list();
    }

    @Override
    public void deleteRanking(PlayerRanking ranking) {
        sessionFactory.getCurrentSession().delete(ranking);
    }

    @Override
    public void modifyRanking(PlayerRanking ranking) {
        sessionFactory.getCurrentSession().update(ranking);
    }

    @Override
    public PlayerRanking getRanking(int rankingId) {
        return (PlayerRanking) sessionFactory.getCurrentSession().
                get(PlayerRanking.class, rankingId);
    }

    @Override
    public List<PlayerRanking> getAllRankingsByPlayerName(String name) {
        return null;
    }

    @Override
    public List<PlayerRanking> getAllRankingsByPlayerName(String firstName, String lastName) {
        return null;
    }

}
