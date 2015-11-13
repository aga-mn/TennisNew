package tennis.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import tennis.bo.Players;
import tennis.exceptions.InvalidInputException;
import tennis.exceptions.NoDataFoundException;
import tennis.model.Player;

@WebService
public interface PlayerWebService {
	
	@WebMethod(operationName="getPlayer") 
	@WebResult(name="Player")
	public Player getPlayerByUsername (@WebParam(name="username")String username) throws InvalidInputException ;
	
	@WebMethod(operationName="deletePlayer")
	public void deletePlayer(@WebParam(name="playerId") String playerId) throws NoDataFoundException;
	
	@WebMethod(operationName="getAllPlayers")
	@WebResult(name="PlayerList")
	public Players getAllPlayers();
	
	@WebMethod(operationName="addPlayer")
	public void addPlayer(@WebParam(name="firstName")String name, @WebParam(name="lastName")String lastName, 
						@WebParam(name="username")String username, @WebParam(name="gender")String gender) throws InvalidInputException;
	
	@WebMethod(operationName="modifyPlayer")
	public void modifyPlayer(@WebParam(name="playerId")String playerId, @WebParam(name="firstName")String name, @WebParam(name="lastName")String lastName, 
						@WebParam(name="username")String username) ;
	
	@WebMethod(operationName="getPlayersByLastName")
	@WebResult(name="Playerlist")
	public Players getPlayersByLastName(@WebParam(name="lastName")String lastName);

}
