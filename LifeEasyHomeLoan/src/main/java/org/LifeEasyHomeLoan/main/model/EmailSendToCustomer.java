package org.LifeEasyHomeLoan.main.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class EmailSendToCustomer {
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String textBody;
}
