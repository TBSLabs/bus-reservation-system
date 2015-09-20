package org.ticketbooking.core.api.exception;

/**
 * <p> This class will throw the validation Message through out the application</p>
 * @author cooligc
 * */
public class ApplicationValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String validationMessage;
	private String validationCode;
	
	public ApplicationValidationException(String validationMessage,String validationCode) {
		super(validationMessage);
		this.validationMessage = validationMessage;
		this.validationCode = validationCode;
	}
	
	public String getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	
	@Override
	public String toString() {
		return "ApplicationValidationException [validationMessage="
				+ validationMessage + ", validationCode=" + validationCode
				+ "]";
	}
	
	

}
