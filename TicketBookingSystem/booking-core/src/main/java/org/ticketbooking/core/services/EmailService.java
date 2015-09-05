package org.ticketbooking.core.services;

import java.util.Map;

public interface EmailService {
	void sendEmail(Map<String, String> mailAttributes);
}
