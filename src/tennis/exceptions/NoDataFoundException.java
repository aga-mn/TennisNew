package tennis.exceptions;

public class NoDataFoundException extends Exception {
	private String errorDetails;

	public NoDataFoundException(String reason, String details) {
		super(reason);
		this.errorDetails = details;
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}	 

}
