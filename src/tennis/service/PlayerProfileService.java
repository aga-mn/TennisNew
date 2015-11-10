package tennis.service;

import java.util.List;

import tennis.model.PlayerProfile;

public interface PlayerProfileService {	

    void addPlayerProfile(PlayerProfile profile);
    List<PlayerProfile> getAllProfiles();
    void deletePlayerProfile(PlayerProfile profile);
    void modifyPlayerProfile(PlayerProfile profile);
    PlayerProfile getPlayerProfile(int playerProfileId);

}
