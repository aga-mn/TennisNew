package tennis.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.beans.factory.annotation.Autowired;

import tennis.bo.Clubs;
import tennis.model.Club;
import tennis.service.ClubService;

@WebService(serviceName="ClubWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class ClubWebService {
	
	@Autowired
	private ClubService clubService;

	@WebMethod(operationName="getClub")
	public Club getClub(@WebParam(name="clubId") String clubId) {
		return clubService.getClub(clubId);
	}
	
	@WebMethod(operationName="addClub")
	public void addClub(@WebParam(name="clubName") String clubName, @WebParam(name="clubStreet") String clubStreet,
			@WebParam(name="clubStreetNumber") String clubStreetNumber, @WebParam(name="clubPostCode") String clubPostCode,
			@WebParam(name="clubCity") String clubCity, @WebParam(name="clubDescription") String clubDescription) {
			Club club = new Club();
			club.setClubName(clubName);
			club.setStreet(clubStreet);
			club.setStreetNumber(clubStreetNumber);
			club.setCity(clubCity);
			club.setPostCode(clubPostCode);
			club.setDescription(clubDescription);
			clubService.addClub(club);		
	}
	
	@WebMethod(operationName="getAllClubs")
	public Clubs getAllClubs() {
		Clubs clubs = new Clubs();
		List<Club> clubsFromDB = clubService.getAllClubs();
		clubs.setClubs(clubsFromDB);
		return clubs;		
	}

	@WebMethod(operationName="deleteClub") 
	public void deleteClub(@WebParam(name="clubId") String clubId) {
		Club club = clubService.getClub(clubId);
		clubService.deleteClub(club);
		
	}
	
	@WebMethod(operationName="modifyClub")
	public void modifyClub(@WebParam(name="clubId") String clubId, @WebParam(name="clubName") String clubName, 
			@WebParam(name="clubStreet") String clubStreet,
			@WebParam(name="clubStreetNumber") String clubStreetNumber, 
			@WebParam(name="clubPostCode") String clubPostCode,
			@WebParam(name="clubCity") String clubCity, 
			@WebParam(name="clubDescription") String clubDescription) {
		Club club = clubService.getClub(clubId);
		if (!club.getCity().equals(clubCity)) {
			club.setCity(clubCity);
		}
		if (!club.getClubName().equals(clubName)) {
			club.setClubName(clubName);
		}
		if (!club.getDescription().equals(clubDescription)) {
			club.setDescription(clubDescription);
		}
		if (!club.getPostCode().equals(clubPostCode)) {
			club.setPostCode(clubPostCode);
		}
		if (!club.getStreet().equals(clubStreet)) {
			club.setStreet(clubStreet);
		}
		if (!club.getStreetNumber().equals(clubStreetNumber)) {
			club.setStreetNumber(clubStreetNumber);
		}
		clubService.modifyClub(club);
	}
}
