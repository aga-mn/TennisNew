package tennis.dao;

import java.util.List;

import tennis.model.Match;

public interface MatchDao {
	
    void addMatch (Match match);
    List<Match> getAllMatches();
    void deleteMatch(Match match);
    void modifyMatch(Match match);
    Match getMatch(int matchId);

}
