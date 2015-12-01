package tennis.bo;

import java.util.List;

import org.springframework.stereotype.Component;

import tennis.model.Match;

@Component
public class Matches {
	
	private List<Match> matches;

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}
