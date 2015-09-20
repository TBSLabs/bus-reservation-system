package org.ticketbooking.common.concurrency.context;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.WebRequest;
import org.ticketbooking.common.concurrency.ThreadLocalManager;

public class TicketBookingContext {
	private static final ThreadLocal<TicketBookingContext> TICKET_BOOKING_REQUEST_CONTEXT = ThreadLocalManager.createThreadLocal(TicketBookingContext.class);
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Locale locale;
	protected Map<String, Object> additionalProperties = new HashMap<String, Object>();
	protected Currency currency;
	protected WebRequest webRequest;
	protected TimeZone timeZone;
	
	public static void setTicketBookingContext(TicketBookingContext bookingContext){
		TICKET_BOOKING_REQUEST_CONTEXT.set(bookingContext);
	}
	
	public static TicketBookingContext getTicketBookingContext(){
		return TICKET_BOOKING_REQUEST_CONTEXT.get();
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public WebRequest getWebRequest() {
		return webRequest;
	}

	public void setWebRequest(WebRequest webRequest) {
		this.webRequest = webRequest;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	
	
}
