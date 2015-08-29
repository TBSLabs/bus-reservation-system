package org.ticketbooking.core.api.jaxb.other;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "links")
public class Links {
	private String relationType;
	private String url;
	
	public Links(String relationType, String url) {
		super();
		this.relationType = relationType;
		this.url = url;
	}
	public Links() {}
	
	@XmlElement(name="rel")
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	@XmlElement(name="_href")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
