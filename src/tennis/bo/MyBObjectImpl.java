package tennis.bo;

import tennis.bo.MyBObject;

public class MyBObjectImpl implements MyBObject {

	@Override
	public String printMessage(String message) {
		return "Hello from " + message;
	}
}