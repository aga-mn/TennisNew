package tennis.dao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tennis.model.Club;
import tennis.model.Tournament;

import java.util.Date;
import java.util.List;

/**
 * Created by amolda on 30.11.14.
 */
@Repository
public class ClubDaoImpl implements ClubDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addClub(Club club) {
        sessionFactory.getCurrentSession().save(club);
    }

    @SuppressWarnings("unchecked")
	public List<Club> getAllClubs() {
        return sessionFactory.getCurrentSession().createQuery("from Club").
                list();
    }

    public void deleteClub(Club club) {
        sessionFactory.getCurrentSession().delete(club);
    }

    public void modifyClub(Club club) {
        sessionFactory.getCurrentSession().update(club);
    }

    public Club getClub(String clubId) {
        return (Club) sessionFactory.getCurrentSession().get(Club.class, Integer.parseInt(clubId));
    }

//    @SuppressWarnings("unchecked")
//	@Override
//    public List<Tournament> getTournamentsByClubAndDate(String clubId, Date fromDate, Date toDate) {
//        Club club = getClub(clubId);
//        Query query = sessionFactory.getCurrentSession().createQuery
//                ("from Tournament where club=:club and tournamentDate between :fromDate and :toDate");
//                query.setParameter("club", club);
//                query.setParameter("fromDate", fromDate);
//                query.setParameter("toDate", toDate);
//        return query.list();
//    }

/*    @Override
    public List<Tournament> getAllTournamentsByClub(int clubId) {
        Club club = getClub(clubId);
        Query query = sessionFactory.getCurrentSession().createQuery("from Tournament where club=:club");
        query.setParameter("club", club);
        return query.list();
    }*/
}