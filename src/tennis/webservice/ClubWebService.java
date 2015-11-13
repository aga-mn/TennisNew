package tennis.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import tennis.bo.Clubs;
import tennis.model.Club;

@WebService
public interface ClubWebService {
	@WebMethod(operationName="getClub")
	public Club getClub(@WebParam(name="clubId") String clubId);
	
	@WebMethod(operationName="addClub")
	public void addClub(@WebParam(name="clubName") String clubName, @WebParam(name="clubStreet") String clubStreet,
			@WebParam(name="clubStreetNumber") String clubStreetNumber, @WebParam(name="clubPostCode") String clubPostCode,
			@WebParam(name="clubCity") String clubCity, @WebParam(name="clubDescription") String clubDescription);
	
	@WebMethod(operationName="getAllClubs")
	public Clubs getAllClubs();

	@WebMethod(operationName="deleteClub") 
	public void deleteClub(@WebParam(name="clubId") String clubId);
	
	@WebMethod(operationName="modifyClub")
	public void modifyClub(@WebParam(name="clubId") String clubId, @WebParam(name="clubName") String clubName, 
			@WebParam(name="clubStreet") String clubStreet,
			@WebParam(name="clubStreetNumber") String clubStreetNumber, 
			@WebParam(name="clubPostCode") String clubPostCode,
			@WebParam(name="clubCity") String clubCity, 
			@WebParam(name="clubDescription") String clubDescription) ;

}
