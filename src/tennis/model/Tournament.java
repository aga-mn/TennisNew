package tennis.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int tournamentId;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Temporal(value = TemporalType.DATE)
    @Column(name="tournament_date")
    private Date tournamentDate;
    @Column(name="tournament_location")
    private String location;
    @Column(name="surface")
    private String surface;
    @Column(name="draw")
    private int draw;                // rozmiar drabinki
    @Column(name="seeds")
    private boolean seeds;           // czy jest rozstawienie
    @Column(name="number_of_seeds")
    private int numberOfSeeds;

    @OneToMany(mappedBy = "tournament")
    private Set<Match> matches;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public boolean isSeeds() {
        return seeds;
    }

    public void setSeeds(boolean seeds) {
        this.seeds = seeds;
    }

    public int getNumberOfSeeds() {
        return numberOfSeeds;
    }

    public void setNumberOfSeeds(int numberOfSeeds) {
        this.numberOfSeeds = numberOfSeeds;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(Date tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public double getNumberOfRounds () {
        return Math.log(draw)/Math.log(2);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "club= " + club.getClubId() + '\'' +
                "tournamentId= " + tournamentId +
                ", tournamentDate= " + tournamentDate +
                ", location= '" + location + '\'' +
                ", surface= '" + surface + '\'' +
                '}';
    }
}