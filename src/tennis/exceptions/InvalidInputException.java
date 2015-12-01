package tennis.exceptions;

public class InvalidInputException extends RuntimeException {
	
	private String errorDetails;

	public InvalidInputException(String reason, String details) {
		super(reason);
		this.errorDetails = details;
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}	 

}
