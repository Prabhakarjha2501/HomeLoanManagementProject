package org.LifeEasyHomeLoan.main.serviceimpl;

import org.LifeEasyHomeLoan.main.model.EmailSendToCustomer;
import org.LifeEasyHomeLoan.main.servicei.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailSendImpl implements EmailService{
	@Autowired
	JavaMailSender sender;
	@Override
	public void sendemail(EmailSendToCustomer emailsendtocustomer) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(emailsendtocustomer.getToEmail());
		message.setFrom(emailsendtocustomer.getFromEmail());
		message.setSubject(emailsendtocustomer.getSubject());
		message.setText(emailsendtocustomer.getTextBody());
		sender.send(message);
	}

	
}
