package tennis.bo;

import java.util.List;

import org.springframework.stereotype.Component;

import tennis.model.Player;

@Component
public class Players {
	
	private List<Player> players;
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}



}
