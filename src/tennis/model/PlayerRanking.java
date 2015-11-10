package tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_ranking")
public class PlayerRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ranking_id")
    private int rankingId;
    @Column(name = "season")
    private String season;
    @Column(name = "matches_won")
    private int matchesWon;
    @Column(name = "matches_lost")
    private int matchesLost;
    @Column(name = "sets_won")
    private int setsWon;
    @Column(name = "sets_lost")
    private int setsLost;
    @Column(name = "games_won")
    private int gamesWon;
    @Column(name = "games_lost")
    private int gamesLost;
    @Column(name = "walkovers")
    private int walkovers;
    @Column(name = "retirements")
    private int retirements;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void setSetsWon(int setsWon) {
        this.setsWon = setsWon;
    }

    public int getSetsLost() {
        return setsLost;
    }

    public void setSetsLost(int setsLost) {
        this.setsLost = setsLost;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    @Override
    public String toString() {
        return "PlayerRanking{" +
                "rankingId=" + rankingId +
                ", season='" + season + '\'' +
                ", matchesWon=" + matchesWon +
                ", matchesLost=" + matchesLost +
                ", setsWon=" + setsWon +
                ", setsLost=" + setsLost +
                ", gamesWon=" + gamesWon +
                ", gamesLost=" + gamesLost +
                ", walkovers=" + walkovers +
                ", retirements=" + retirements +
                ", player=" + player +
                '}';
    }
}
