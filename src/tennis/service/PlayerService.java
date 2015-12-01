package tennis.service;


import java.util.List;

import tennis.exceptions.InvalidInputException;
import tennis.model.Player;

public interface PlayerService {

    void addPlayer(Player player) throws InvalidInputException;
    List<Player> getAllPlayers();
    void deletePlayer(Player player);
    void modifyPlayer(Player player);
    Player getPlayer(String playerId);
    Player getPlayerByUsername(String username);
    List<Player> getPlayersByLastName(String lastName);
}