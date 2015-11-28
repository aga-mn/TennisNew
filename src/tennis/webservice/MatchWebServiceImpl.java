package tennis.webservice;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import tennis.bo.Matches;
import tennis.model.Match;
import tennis.model.Player;
import tennis.service.MatchService;
import tennis.service.PlayerService;

@WebService
public class MatchWebServiceImpl implements MatchWebService {
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private PlayerService playerService;

	@Override
	public Match getMatch(@WebParam(name="matchId") String matchId) {
		return matchService.getMatch(matchId);

	}

	@Override
	public Matches getMatchesByPlayer(@WebParam(name="username") String username) {
		Player player = playerService.getPlayerByUsername(username);
		String playerId = Integer.toString(player.getPlayerId());
		List<Match> matchesFromDB = matchService.getMatchesByPlayer(playerId);
		Matches matches = new Matches();
		matches.setMatches(matchesFromDB);
		return matches;
	}

	@Override
	public Matches getMatchesByTwoPlayers(@WebParam(name="firstPlayerUsername") String firstPlayerUsername, 
			@WebParam(name="secondPlayerUsername") String secondPlayerUsername) {
			Player player1 = playerService.getPlayerByUsername(firstPlayerUsername);
			Player player2 = playerService.getPlayerByUsername(secondPlayerUsername);
			//String firstPlayerId = Integer.toString(player1.getPlayerId());
			//String secondPlayerId = Integer.toString(player2.getPlayerId());
			List<Match> matchesFromDB = matchService.getMatchesByTwoPlayers(firstPlayerUsername, secondPlayerUsername);
			Matches matches = new Matches();
			matches.setMatches(matchesFromDB);
			return matches;
	}

	@Override
	public void addMatch(@WebParam(name="tournamentId") String tournamentId, 
			@WebParam(name="firstPlayerId") String firstPlayerId,
			@WebParam(name="secondPlayerId") String secondPlayerId, 
			@WebParam(name="numberOfSets") String numberOfSets,
			@WebParam(name="firstPlayerSet1") String firstPlayerSet1, 
			@WebParam(name="firstPlayerSet2") String firstPlayerSet2,
			@WebParam(name="firstPlayerSet3") String firstPlayerSet3,
			@WebParam(name="secondPlayerSet1") String secondPlayerSet1,
			@WebParam(name="secondPlayerSet2") String secondPlayerSet2,
			@WebParam(name="secondPlayerSet3") String secondPlayerSet3,
			@WebParam(name="firstSetTiebreak") String firstSetTiebreak,
			@WebParam(name="secondSetTiebreak") String secondSetTiebreak,
			@WebParam(name="thirdSetTiebreak") String thirdSetTiebreak,
			@WebParam(name="walkover") String walkover,
			@WebParam(name="retirement") String retirement) {
		Match match = new Match();
		Integer setsNum = Integer.parseInt(numberOfSets);
		match.setNumberOfSets(setsNum);
		match.setPlayer1(Integer.parseInt(firstPlayerId));
		match.setPlayer2(Integer.parseInt(secondPlayerId));
		match.setFirstSetPlayer1(Integer.parseInt(firstPlayerSet1));
		match.setFirstSetPlayer2(Integer.parseInt(secondPlayerSet1));
		if (match.getFirstSetPlayer1() > match.getFirstSetPlayer2()) {
			match.setFirstSetWinner(Integer.parseInt(firstPlayerId));
		} else {
			match.setFirstSetWinner(Integer.parseInt(secondPlayerId));
		}
		if (match.getSecondSetPlayer1() > match.getSecondSetPlayer2()) {
			match.setSecondSetWinner(Integer.parseInt(firstPlayerId));
		} else {
			match.setSecondSetWinner(Integer.parseInt(secondPlayerId));
		}
		match.setSecondSetPlayer1(Integer.parseInt(firstPlayerSet2));
		match.setSecondSetPlayer2(Integer.parseInt(secondPlayerSet2));
		if (setsNum > 2) {
			match.setThirdSetPlayer1(Integer.parseInt(firstPlayerSet3));
			match.setThirdSetPlayer2(Integer.parseInt(secondPlayerSet3));			
		}
		if (setsNum == 2) {
			match.setMatchWinner(match.getSecondSetWinner());
		} else {
			match.setMatchWinner(match.getThirdSetWinner());
		}
		
		matchService.addMatch(match);
	}

	@Override
	public void deleteMatch(@WebParam(name="matchId") String matchId) {
		Match match = matchService.getMatch(matchId);
		matchService.deleteMatch(match);

	}

}
