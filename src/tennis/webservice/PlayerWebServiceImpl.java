package tennis.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

import tennis.bo.MyBObject;
import tennis.bo.Players;
import tennis.exceptions.InvalidInputException;
import tennis.exceptions.NoDataFoundException;
import tennis.model.Player;
import tennis.service.PlayerService;


//wsdlLocation = "WEB-INF/WSDL/PlayerWSDL.wsdl", 
@WebService( portName="PlayerServicePort", serviceName="PlayerService")
public class PlayerWebServiceImpl implements PlayerWebService {

	@Autowired
	private PlayerService playerService;	
	
	@Autowired
	private MyBObject myBObject;
	
	@Autowired
	private Players players;

	@WebMethod(operationName="printMessage", exclude=true)
	public String printMessage(String message) {

		return myBObject.printMessage(message);
	}
	
	@WebMethod(operationName="getPlayer") 
	public Player getPlayerByUsername (@WebParam(name="username")String username) throws InvalidInputException {

			return playerService.getPlayerByUsername(username);
		
	}
	
	public void deletePlayer(String username) throws NoDataFoundException {
		Player player = playerService.getPlayerByUsername(username);

			playerService.deletePlayer(player);
						
	}
	
	public Players getAllPlayers() {
		List<Player> playersFromDB = playerService.getAllPlayers();
		players.setPlayers(playersFromDB);
		return players;

	}
	
	@WebMethod(operationName="addPlayer")
	public void addPlayer(@WebParam(name="firstName")String name, @WebParam(name="lastName")String lastName, 
			@WebParam(name="username")String username, @WebParam(name="gender")String gender) throws InvalidInputException {
		Player player = new Player();
		player.setFirstName(name);
		player.setLastName(lastName);
		player.setUsername(username);
		player.setGender(gender);
		
		
		playerService.addPlayer(player);
		
		
//		String charactersOnlyRegex = "[a-zA-Z]+";
//		Pattern pattern = Pattern.compile(charactersOnlyRegex);
//		Matcher matcher = pattern.matcher(name);
//		boolean firstNameMatch = matcher.matches();
//		if (!firstNameMatch) {
//			throw new InvalidInputException("Invalid input", "Name can contain only character");
//		} else {
//			player.setFirstName(name);
//		}
//		matcher = pattern.matcher(lastName);
//		boolean lastNameMatch = matcher.matches();
//		if (!lastNameMatch) {
//			throw new InvalidInputException("Invalid input", "Last name can contain only character");
//		} else {
//			player.setLastName(lastName);
//		}
//		String whiteSpaces = "[a-zA-Z-_.]+";
//		pattern = Pattern.compile(whiteSpaces);
//		matcher = pattern.matcher(username);
//		boolean usernameMatch = matcher.matches();
//		if (!usernameMatch) {
//			throw new InvalidInputException("Invalid input", "Username contains invalid character");
//		} else {
//			player.setUsername(username);
//		}
//		boolean genderMatches = gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
//		if (!genderMatches) {
//			throw new InvalidInputException("Invalid input", "gender accepts values: male, female");
//		} else {
//			player.setGender(gender);
//		}
//		boolean allDataCorrect = firstNameMatch && lastNameMatch && usernameMatch && genderMatches;
//		if (allDataCorrect) {
//			playerService.addPlayer(player);
//		}		
		playerService.addPlayer(player);
	}
	
	public void modifyPlayer(@WebParam(name="playerId")String playerId, @WebParam(name="firstName")String name, @WebParam(name="lastName")String lastName, 
			@WebParam(name="username")String username) {
		Player player = playerService.getPlayer(playerId);
		if (!username.equals(player.getUsername())) {
			player.setUsername(username);
		} 
		if (!name.equals(player.getFirstName())) {
			player.setFirstName(name);
		}
		if (!lastName.equals(player.getLastName())) {
			player.setLastName(lastName);
		}

		playerService.modifyPlayer(player);
	}
	
	public Players getPlayersByLastName(String lastName) {
		List<Player> playersFromDB = playerService.getPlayersByLastName(lastName);
		players.setPlayers(playersFromDB);
		return players;
	}
	
}