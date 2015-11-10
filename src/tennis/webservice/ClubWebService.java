package tennis.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;

import tennis.model.Club;
import tennis.service.ClubService;

@WebService(serviceName="ClubWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class ClubWebService {
	
	@Autowired
	private ClubService clubService;
	
	@WebMethod
	public Club getClub(@WebParam(name="clubId") String clubId) {
		return clubService.getClub(clubId);
	}

}
