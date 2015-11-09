package tennis.bo;

import org.springframework.stereotype.Component;

import tennis.bo.MyBObject;

@Component 
public class MyBObjectImpl implements MyBObject {

	@Override
	public String printMessage(String message) {
		return "Hello from " + message;
	}
}