package org.ticketbooking.core.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.ticketbooking.core.api.jaxb.other.Links;


public class LinksHelper {
	
	@Value("application.host.name")
	String host;
	
	@Value("application.port.number")
	String portNumber;
	
	@Value("application.path")
	String path;
	
	@Value("application.channel")
	String channel;
	
	@Value("application.isHttps")
	boolean isHttps;

	static String url="http://localhost:8080/";
	
	public static List<Links> createUserLinks(String username){
		List<Links> links = new ArrayList<Links>();
		Links links1 = new Links("dashbord",url+"dashbord/"+username);
		Links links2 = new Links("account_history",url+"booking/"+username+"/history");
		Links links3 = new Links("user_home",url+"dashbord/"+username+"/profile");
		links.add(links1);
		links.add(links2);
		links.add(links3);
		return links;
	}
}
