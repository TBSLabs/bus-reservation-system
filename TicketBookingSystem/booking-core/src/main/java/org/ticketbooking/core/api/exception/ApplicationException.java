package org.ticketbooking.core.api.exception;

/**
 * <p> Common Exception that the application throws</p>
 * @author cooligc
 * */
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	private String errorLink;
	
	public ApplicationException() {}
	public ApplicationException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ApplicationException(String errorCode, String errorMessage,String errorLink) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorLink = errorLink;
	}
	
	
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorLink() {
		return errorLink;
	}

	public void setErrorLink(String errorLink) {
		this.errorLink = errorLink;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
