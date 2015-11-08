package tennis.webservice;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import tennis.model.Player;
import tennis.service.PlayerService;
import tennis.bo.*;

@WebService(endpointInterface = "tennis.webservice.TennisOP")
public class TennisOPImpl implements TennisOP {

	@Autowired
	MyBObject myBObject;
	@Autowired
	private PlayerService playerService;

	@Override
	public String getPlayer(int PlayerId) {

		// Player player1 ;
		System.out.println("Agata " + playerService);
		// player1= playerService.getPlayer(PlayerId);

		// TODO Auto-generated method stub
		return "Hello World of JAX-WS " + myBObject.printMessage("Agata");
		// +player1.getPlayerId();
	}

}
