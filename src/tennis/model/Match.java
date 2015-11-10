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
@Table(name = "tennis_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_id")
    private int matchId;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(name = "round")
    private int round;
    @Column(name = "player_1_id")
    private int player1;
    @Column(name = "player_2_id")
    private int player2;
    @Column(name = "number_of_sets")
    private int numberOfSets;
    @Column(name = "first_set_player_1")
    private int firstSetPlayer1;
    @Column(name = "first_set_player_2")
    private int firstSetPlayer2;
    @Column(name = "second_set_player_1")
    private int secondSetPlayer1;
    @Column(name = "second_set_player_2")
    private int secondSetPlayer2;
    @Column(name = "third_set_player_1")
    private int thirdSetPlayer1;
    @Column(name = "third_set_player_2")
    private int thirdSetPlayer2;
    @Column(name = "first_set_tiebreak")
    private boolean firstSetTiebreak;
    @Column(name = "second_set_tiebreak")
    private boolean secondSetTiebreak;
    @Column(name = "third_set_tiebreak")
    private boolean thirdSetTiebreak;
    @Column(name = "first_set_tb_result")
    private int firstSetTiebreakResult;
    @Column(name = "second_set_tb_result")
    private int secondSetTiebreakResult;
    @Column(name = "third_set_tb_result")
    private int thirdSetTiebreakResult;
    @Column(name = "first_set_winner")
    private int firstSetWinner;
    @Column(name = "second_set_winner")
    private int secondSetWinner;
    @Column(name = "third_set_winner")
    private int thirdSetWinner;
    @Column(name = "match_winner")
    private int matchWinner;
    @Column(name = "walkover")
    private boolean walkOver;
    @Column(name = "retirement")
    private boolean retirement;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public int getPlayer1() {
        return player1;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer2() {
        return player2;
    }

    public void setPlayer2(int player2) {
        this.player2 = player2;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public int getFirstSetPlayer1() {
        return firstSetPlayer1;
    }

    public void setFirstSetPlayer1(int firstSetPlayer1) {
        this.firstSetPlayer1 = firstSetPlayer1;
    }

    public int getFirstSetPlayer2() {
        return firstSetPlayer2;
    }

    public void setFirstSetPlayer2(int firstSetPlayer2) {
        this.firstSetPlayer2 = firstSetPlayer2;
    }

    public int getSecondSetPlayer1() {
        return secondSetPlayer1;
    }

    public void setSecondSetPlayer1(int secondSetPlayer1) {
        this.secondSetPlayer1 = secondSetPlayer1;
    }

    public int getSecondSetPlayer2() {
        return secondSetPlayer2;
    }

    public void setSecondSetPlayer2(int secondSetPlayer2) {
        this.secondSetPlayer2 = secondSetPlayer2;
    }

    public int getThirdSetPlayer1() {
        return thirdSetPlayer1;
    }

    public void setThirdSetPlayer1(int thirdSetPlayer1) {
        this.thirdSetPlayer1 = thirdSetPlayer1;
    }

    public int getThirdSetPlayer2() {
        return thirdSetPlayer2;
    }

    public void setThirdSetPlayer2(int thirdSetPlayer2) {
        this.thirdSetPlayer2 = thirdSetPlayer2;
    }

    public boolean isFirstSetTiebreak() {
        return firstSetTiebreak;
    }

    public void setFirstSetTiebreak(boolean firstSetTiebreak) {
        this.firstSetTiebreak = firstSetTiebreak;
    }

    public boolean isSecondSetTiebreak() {
        return secondSetTiebreak;
    }

    public void setSecondSetTiebreak(boolean secondSetTiebreak) {
        this.secondSetTiebreak = secondSetTiebreak;
    }

    public boolean isThirdSetTiebreak() {
        return thirdSetTiebreak;
    }

    public void setThirdSetTiebreak(boolean thirdSetTiebreak) {
        this.thirdSetTiebreak = thirdSetTiebreak;
    }

    public int getFirstSetTiebreakResult() {
        return firstSetTiebreakResult;
    }

    public void setFirstSetTiebreakResult(int firstSetTiebreakResult) {
        this.firstSetTiebreakResult = firstSetTiebreakResult;
    }

    public int getSecondSetTiebreakResult() {
        return secondSetTiebreakResult;
    }

    public void setSecondSetTiebreakResult(int secondSetTiebreakResult) {
        this.secondSetTiebreakResult = secondSetTiebreakResult;
    }

    public int getThirdSetTiebreakResult() {
        return thirdSetTiebreakResult;
    }

    public void setThirdSetTiebreakResult(int thirdSetTiebreakResult) {
        this.thirdSetTiebreakResult = thirdSetTiebreakResult;
    }

    public int getFirstSetWinner() {
        return firstSetWinner;
    }

    public void setFirstSetWinner(int firstSetWinner) {
        this.firstSetWinner = firstSetWinner;
    }

    public int getSecondSetWinner() {
        return secondSetWinner;
    }

    public void setSecondSetWinner(int secondSetWinner) {
        this.secondSetWinner = secondSetWinner;
    }

    public int getThirdSetWinner() {
        return thirdSetWinner;
    }

    public void setThirdSetWinner(int thirdSetWinner) {
        this.thirdSetWinner = thirdSetWinner;
    }

    public int getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(int matchWinner) {
        this.matchWinner = matchWinner;
    }

    public boolean isWalkOver() {
        return walkOver;
    }

    public void setWalkOver(boolean walkOver) {
        this.walkOver = walkOver;
    }

    public boolean isRetirement() {
        return retirement;
    }

    public void setRetirement(boolean retirement) {
        this.retirement = retirement;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", tournament=" + tournament +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", numberOfSets=" + numberOfSets +
                ", matchWinner=" + matchWinner +
                '}';
    }
}