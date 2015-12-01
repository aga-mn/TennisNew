package tennis.service;

import java.util.List;

import tennis.model.Match;

/**
 * Created by amolda on 12.04.15.
 */
public interface MatchService {

    public void addMatch(Match match);

    public List<Match> getAllMatches();

    public void deleteMatch(Match match);

    public void modifyMatch(Match match);

    public Match getMatch(String matchId);
    
    public List<Match> getMatchesByPlayer(String playerId);
    
    public List<Match> getMatchesByTwoPlayers(String firstPlayerId, String secondPlayerId);
}