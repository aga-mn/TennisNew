package tennis.calculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName= "CalculatorProgram")
public class Calculator {
	
	@WebMethod
	public int addition(int param1, int param2){
		
		return param1+param2;
	}
		
}
