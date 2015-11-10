package tennis.service;

import java.util.List;

import tennis.model.PlayerRanking;

public interface PlayerRankingService {
	
    void addRanking(PlayerRanking ranking);
    List<PlayerRanking> getAllRankings();
    void deleteRanking(PlayerRanking ranking);
    void modifyRanking(PlayerRanking ranking);
    PlayerRanking getRanking(int playerId);

}
