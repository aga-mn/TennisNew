package tennis.dao;

import java.util.List;

import tennis.model.Player;

public interface PlayerDao {

    void addPlayer(Player player);
    List<Player> getAllPlayers();
    void deletePlayer(Player player);
    void modifyPlayer(Player player);
    Player getPlayer(int playerId);
    Player getPlayerByUsername(String username);
    List<Player> getPlayersByLastName(String lastName);

}