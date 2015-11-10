package tennis.bo;

import java.util.List;

import org.springframework.stereotype.Component;

import tennis.model.Club;

@Component
public class Clubs {
	
	private List<Club> clubs;

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

}
