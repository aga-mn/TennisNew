package tennis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tennis.model.Tournament;

@Repository
public class TournamentDaoImpl implements TournamentDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addTournament(Tournament tournament) {
        sessionFactory.getCurrentSession().save(tournament);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllTournaments() {
        return sessionFactory.getCurrentSession().
                createQuery("from Tournament").list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllTournamentsByDate(Date fromDate, Date toDate) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Tournament where tournamentDate between :fromDate and :toDate");
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        return query.list();
    }

    @Override
    public void deleteTournament(Tournament tournament) {
        sessionFactory.getCurrentSession().delete(tournament);
    }

    @Override
    public void modifyTournament(Tournament tournament) {
        sessionFactory.getCurrentSession().update(tournament);
    }

    @Override
    public Tournament getTournament(int tournamentId) {
        return (Tournament) sessionFactory.getCurrentSession().
                get(Tournament.class, tournamentId);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllTournamentsByLocation(String location) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Tournament where location like :location");
        //todo dorobić ignorecase
        query.setParameter("location", "%"+location+"%");
        return query.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllTournamentsByLocationAndDate(String location, Date fromDate, Date toDate) {
        Query query = sessionFactory.getCurrentSession().createQuery
                ("from Tournament where location like :location and tournamentDate between :fromDate and :toDate");
        //TODO dorobić ignorecase
        query.setParameter("location", "%"+location+"%");
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        return query.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllActiveTournaments() {
        Date date = new Date();
        Query query = sessionFactory.getCurrentSession().createQuery("from Tournament where tournamentDate >= :date");
        query.setParameter("date", date);
        return query.list();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tournament> getAllActiveTournamentsByLocation(String location) {
        Date date = new Date();
        Query query = sessionFactory.getCurrentSession().createQuery
                ("from Tournament where tournamentDate >= :date and location like :location");
        query.setParameter("date", date);
        query.setParameter("location", "%"+location+"%");
        return query.list();
    }
}
