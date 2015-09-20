package org.ticketbooking.common.constants;

public interface ApplicationConstants {
	/**
	 * Delimeters
	 * */
	String DELIM_SPACE=" ";
	String DELIM_SEMI_COLLON=";";
	String DELIM_NEW_LINE="/n";
	
	/**
	 * Error Codes
	 * */
	String ERROR="ERR_";
	String VALIDATION="VALIDATION";
	String ERROR_4000=ERROR+4000;
	String ERROR_5000=ERROR+5000;
	String VALIDATION_ERROR_2000=VALIDATION+DELIM_SPACE+ERROR+2000;
	
	/**
	 * Error Message
	 * */
	String ERROR_4000_MSG="Unable to process your request";
	String ERROR_5000_MSG="Please try after some time";
	String VALIDATION_ERROR_2000_MSG="Some field are not validated properly. Please validate and re-send it";
	
	/**
	 * Script Executer Details
	 * */
	String END_OF_SCRIPT_DELIM=DELIM_SEMI_COLLON;
	String SCRIPT_SINGLE_LINE_COMMENT="--";
	String MULTI_LINE_COMMENT_START="/*";
	String MULTILINE_COMMENT_END="*/";
	
	/**
	 * Web Constants
	 * */
	String TIME_ZONE = "timeZone";
	
}
