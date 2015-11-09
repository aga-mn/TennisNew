package tennis.webservice;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import tennis.bo.MyBObject;
import tennis.service.PlayerService;
import tennis.model.*;


@WebService(serviceName="MyWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class MyWebService extends SpringBeanAutowiringSupport {
	
	@PostConstruct
	public void init() {
	  SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private PlayerService playerService;	
	
	//Dependency Injection (DI) via Spring
	@Autowired
	MyBObject myBObject;

//	@WebMethod(exclude=true)
//	public void setMyBObject(MyBObject bObject) {
//		this.myBObject = bObject;
//	}

	@WebMethod(operationName="printMessage")
	public String printMessage(String message) {

		return myBObject.printMessage(message);
}
	
	
	@WebMethod(operationName="printPlayer")
	public Player printPlayer(int PlayerId) {
		System.out.println("Agata " + playerService.toString());
		return playerService.getPlayer( PlayerId);

	}
	
	
}