package org.ticketbooking.core.services;

import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.ticketbooking.common.annotation.log.Log;

@Service("emailService")
public class EmailServiceImpl implements EmailService{
	
	@Log
	Logger logger;
	
	private static final String TEMPLATES_LOCATIONS="emailTemplates";
	
	@Resource(name="mailSender")
	JavaMailSender mailSender;
	
	@Resource(name="velocityEngine")
	VelocityEngine velocityEngine;
	
	public void sendEmail(Map<String, String> mailAttributes){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailAttributes.get("mail_to"));
		mailMessage.setSubject(mailAttributes.get("mail_subject"));
		Template template = velocityEngine.getTemplate(TEMPLATES_LOCATIONS+"/"+mailAttributes.get("mail_template"));
		
		VelocityContext context = new VelocityContext();
		for (Entry<String, String> entryMail : mailAttributes.entrySet()) {
			context.put(entryMail.getKey(), entryMail.getValue());
		}
		
		StringWriter stringWriter = new StringWriter();
		template.merge(context, stringWriter);
		mailMessage.setText(stringWriter.toString());
		try{
			mailSender.send(mailMessage);
		}catch(Exception exception){
			logger.error(exception);
		}
	}
}
