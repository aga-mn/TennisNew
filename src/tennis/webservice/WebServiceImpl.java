package tennis.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "tennis.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String getHelloWorldAsString(String str) {
		return "Hello World of JAX-WS " + str;
	}

}