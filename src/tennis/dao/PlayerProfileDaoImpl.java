package tennis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tennis.model.PlayerProfile;

@Repository
public class PlayerProfileDaoImpl implements PlayerProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPlayerProfile(PlayerProfile profile) {
       sessionFactory.getCurrentSession().save(profile);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<PlayerProfile> getAllProfiles() {
        return sessionFactory.getCurrentSession().
                createQuery("from PlayerProfile").list();
    }

    @Override
    public void deletePlayerProfile(PlayerProfile profile) {
        sessionFactory.getCurrentSession().delete(profile);
    }

    @Override
    public void modifyPlayerProfile(PlayerProfile profile) {

        sessionFactory.getCurrentSession().update(profile);
    }

    @Override
    public PlayerProfile getPlayerProfile(int playerId) {
        return (PlayerProfile) sessionFactory.getCurrentSession().
                get(PlayerProfile.class, playerId);
    }
}