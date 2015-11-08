package tennis.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "HelloWorld")
public class HelloWorld {

	@WebMethod(operationName = "hello")
	public String helloWorld(String name) {

		return "Hello world from " + name;
	}

	
	@WebMethod(operationName = "getPlayer")
	public String getPlayer(String name) {

		return "getPlayer " + name;
	}	
	
	
	  @WebMethod(operationName="add", action="urn:Add")

      public int add(int i, int j) {

		  
              int k = i +j ;
              System.out.println(i + "+" + j +" = " + k);
               
              return k;
      }	
	
}
