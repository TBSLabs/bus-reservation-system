/**
 * 
 */
package org.ticketbooking.core.web.filter;

import java.io.IOException;
import java.util.TimeZone;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.ticketbooking.common.concurrency.ThreadLocalManager;
import org.ticketbooking.common.concurrency.context.TicketBookingContext;
import org.ticketbooking.common.constants.ApplicationConstants;
import org.ticketbooking.common.utils.ApplicationObjectUtils;

/**
 * <p> Filter to be executed once per {@link HttpServletRequest} and will set the necessary details for a request.</p>
 * @author cooligc
 */
@Component("trsRequestFilter")
public class RequestFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		TicketBookingContext bookingContext = new TicketBookingContext();
		bookingContext.setRequest(request);
		bookingContext.setResponse(response);
		bookingContext.setLocale(request.getLocale());
		WebRequest webRequest = new ServletWebRequest(request, response);
		bookingContext.setWebRequest(webRequest);
		bookingContext.setTimeZone(getTimeZone(webRequest));
		TicketBookingContext.setTicketBookingContext(bookingContext);
		filterChain.doFilter(request, response);
	}
	
	private TimeZone getTimeZone(WebRequest webRequest) {
		TimeZone timeZone = null;
		timeZone = (TimeZone) webRequest.getAttribute(ApplicationConstants.TIME_ZONE, WebRequest.SCOPE_GLOBAL_SESSION);
		if(ApplicationObjectUtils.isNull(timeZone)){
			timeZone = TimeZone.getDefault();
			webRequest.setAttribute(ApplicationConstants.TIME_ZONE, timeZone, WebRequest.SCOPE_GLOBAL_SESSION);
		}		
		return timeZone;
	}

	@Override
	public void destroy() {
		ThreadLocalManager.remove();
		super.destroy();
	}

}
