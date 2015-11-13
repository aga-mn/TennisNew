package tennis.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import tennis.model.Player;

@Component
@XmlRootElement(name="Player")
public class Players {
	
	private List<Player> players;
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}



}
