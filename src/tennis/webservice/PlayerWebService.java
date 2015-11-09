package tennis.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import tennis.bo.MyBObject;
import tennis.bo.Players;
import tennis.service.PlayerService;
import tennis.model.*;


@WebService(serviceName="MyWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class PlayerWebService {

	@Autowired
	private PlayerService playerService;	
	
	@Autowired
	private MyBObject myBObject;
	
	@Autowired
	private Players players;

	@WebMethod(operationName="printMessage")
	public String printMessage(String message) {

		return myBObject.printMessage(message);
	}
	
	
	@WebMethod(operationName="getPlayer")
	public Player getPlayer(@WebParam(name="playerId") int playerId) {
		return playerService.getPlayer(playerId);

	}
	
	@WebMethod(operationName="getPlayerByUsername") 
	public Player getPlayerByUsername (@WebParam(name="username")String username) {
		return playerService.getPlayerByUsername(username);
		
	}
	
	@WebMethod(operationName="deletePlayer")
	public void deletePlayer(@WebParam(name="playerId") int playerId) {
		Player player = playerService.getPlayer(playerId);
		playerService.deletePlayer(player);		
	}
	
	@WebMethod(operationName="getAllPlayers")
	public Players getAllPlayers() {
		List playersFromDB = playerService.getAllPlayers();
		players.setPlayers(playersFromDB);
		return players;

	}
}