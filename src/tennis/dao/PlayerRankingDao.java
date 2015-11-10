package tennis.dao;

import java.util.List;

import tennis.model.PlayerRanking;

public interface PlayerRankingDao {
	
	void addRanking(PlayerRanking ranking);
    List<PlayerRanking> getAllRankings();
    void deleteRanking(PlayerRanking ranking);
    void modifyRanking(PlayerRanking ranking);
    PlayerRanking getRanking(int playerId);
    List<PlayerRanking> getAllRankingsByPlayerName(String name);
    List<PlayerRanking> getAllRankingsByPlayerName(String firstName, String lastName);

}
