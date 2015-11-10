package tennis.dao;

import java.util.List;

import tennis.model.PlayerProfile;


public interface PlayerProfileDao {

    void addPlayerProfile(PlayerProfile profile);
    List<PlayerProfile> getAllProfiles();
    void deletePlayerProfile(PlayerProfile profile);
    void modifyPlayerProfile(PlayerProfile profile);
    PlayerProfile getPlayerProfile(int playerId);
}