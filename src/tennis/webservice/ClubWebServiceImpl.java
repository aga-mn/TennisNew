package tennis.webservice;

import java.util.List;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

import tennis.bo.Clubs;
import tennis.model.Club;
import tennis.service.ClubService;

@WebService(endpointInterface="tennis.webservice.ClubWebService", serviceName="ClubWebService")
public class ClubWebServiceImpl implements ClubWebService {
	
	@Autowired
	private ClubService clubService;

	public Club getClub(String clubId) {
		return clubService.getClub(clubId);
	}
	
	public void addClub(String clubName, String clubStreet, String clubStreetNumber, String clubPostCode,
			String clubCity, String clubDescription) {
			Club club = new Club();
			club.setClubName(clubName);
			club.setStreet(clubStreet);
			club.setStreetNumber(clubStreetNumber);
			club.setCity(clubCity);
			club.setPostCode(clubPostCode);
			club.setDescription(clubDescription);
			clubService.addClub(club);		
	}
	
	public Clubs getAllClubs() {
		Clubs clubs = new Clubs();
		List<Club> clubsFromDB = clubService.getAllClubs();
		clubs.setClubs(clubsFromDB);
		return clubs;		
	}

	public void deleteClub(String clubId) {
		Club club = clubService.getClub(clubId);
		clubService.deleteClub(club);
		
	}
	
	public void modifyClub(String clubId, String clubName, String clubStreet,
			String clubStreetNumber, String clubPostCode, String clubCity, String clubDescription) {
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
