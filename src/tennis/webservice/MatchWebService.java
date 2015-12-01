package tennis.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import tennis.bo.Matches;
import tennis.model.Match;

@WebService
public interface MatchWebService {
	
	@WebMethod(operationName="getMatch")
	public Match getMatch(@WebParam(name="matchId") String matchId);
	
	@WebMethod(operationName="getMatchesByPlayer")
	public Matches getMatchesByPlayer(@WebParam(name="username") String username);
	
	@WebMethod(operationName="getMatchesByTwoPlayers")
	public Matches getMatchesByTwoPlayers(@WebParam(name="firstPlayerUsername") String firstPlayerUsername, 
			@WebParam(name="secondPlayerUsername") String secondPlayerUsername);
	
	@WebMethod(operationName="addMatch")
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
			@WebParam(name="retirement") String retirement);
	
	@WebMethod(operationName="deleteMatch") 
	public void deleteMatch(@WebParam(name="matchId") String matchId);
	
//	@WebMethod(operationName="modifyMatch")
//	public void modifyMatch(@WebParam(name="tournamentId") String tournamentId, 
//			@WebParam(name="firstPlayerId") String firstPlayerId,
//			@WebParam(name="secondPlayerId") String secondPlayerId, 
//			@WebParam(name="numberOfSets") String numberOfSets,
//			@WebParam(name="firstPlayerSet1") String firstPlayerSet1, 
//			@WebParam(name="firstPlayerSet2") String firstPlayerSet2,
//			@WebParam(name="firstPlayerSet3") String firstPlayerSet3,
//			@WebParam(name="secondPlayerSet1") String secondPlayerSet1,
//			@WebParam(name="secondPlayerSet2") String secondPlayerSet2,
//			@WebParam(name="secondPlayerSet3") String secondPlayerSet3,
//			@WebParam(name="firstSetTiebreak") String firstSetTiebreak,
//			@WebParam(name="secondSetTiebreak") String secondSetTiebreak,
//			@WebParam(name="thirdSetTiebreak") String thirdSetTiebreak,
//			@WebParam(name="walkover") String walkover,
//			@WebParam(name="retirement") String retirement);

}
