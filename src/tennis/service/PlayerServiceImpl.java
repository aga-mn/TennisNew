package tennis.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tennis.dao.PlayerDao;
import tennis.model.Player;

@Service
@Transactional //(propagation=Propagation.SUPPORTS, readOnly=true)
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Valid
    @Override
    public void addPlayer(Player player) {
        playerDao.addPlayer(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }

    @Override
    public void deletePlayer(Player player) {
        playerDao.deletePlayer(player);
    }

    @Override
    public void modifyPlayer(Player player) {
        playerDao.modifyPlayer(player);
    }

    @Override
    public Player getPlayer(String playerId) {
        return playerDao.getPlayer(playerId);
    }

    @Override
    public Player getPlayerByUsername(String username) {
        return playerDao.getPlayerByUsername(username);
    }

    @Override
    public List<Player> getPlayersByLastName(String lastName) {
        return playerDao.getPlayersByLastName(lastName);
    }


}