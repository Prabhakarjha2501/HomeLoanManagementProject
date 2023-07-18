 package org.LifeEasyHomeLoan.main.controller;

import org.LifeEasyHomeLoan.main.model.EmailSendToCustomer;
import org.LifeEasyHomeLoan.main.model.EnquiryDetails;
import org.LifeEasyHomeLoan.main.servicei.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
public class EmailController {
	@Autowired
	EmailSendToCustomer emailsendtocustomer;
	@Autowired
	EmailService es;
	@Value("${spring.mail.username}")
	private String fromEmail;
	@PostMapping("/sendEmail/{enquiryId}")
	public ResponseEntity<String>sendmailTouser(@PathVariable("enquiryId") int enquiryId,@RequestBody EnquiryDetails enquirydetails){
		log.info("CibilScore"+enquirydetails.getCibilStatus());
		if(enquirydetails.getCibilStatus().equals("approved")){
		log.info("Approved Mail send To Customer");
		emailsendtocustomer.setFromEmail(fromEmail);
		emailsendtocustomer.setToEmail(enquirydetails.getEmail());
		emailsendtocustomer.setSubject("Regarding Home Loan For Documentation of Applicant name: "+ enquirydetails.getFirstName() +" "+ enquirydetails.getLastName());
		emailsendtocustomer.setTextBody("Your cibil is Approved and You are Eligible\n"
	      		+ "For Further Process."
	      		+ "\n We are happy to inform you that your Home Loan request has been approved and is cureently being processed.\n"
	      		+ "Further, we inform you that we have sent an email containing attached documents.\n"
	      		+ "Also we have sent you the terms and conditions of the loans sanctioned. \n"
	      		+ "We would like to schedule your meeting with the finance officer of the company for any further information and clarifications that you might wish to know. \n\n"
	      		+ "We are happy to be doing business with you. \n\n"
	      		+ "List of Documents Required :- \n\n"
	      		+ "1.Aadhar Card \n"
	      		+ "2.Pan Card \n"
	      		+ "3.Income Tax Return of Last Two Years \n"
	      		+ "4.Salary Slips of Last Three Months \n"
	      		+ "5.Passport Size Photograph \n"
	      		+ "6.Bank Passbook Copy \n"
	      		+ "\n \n Thanking You. \n"
	      		+ "Mr.PravinDongare\n"
	      		+ "Branch Manager \n"
	      		+ "LifeEasyHomeLoan Finance Ltd. \n Karvenagar \n"
	      		+ "Pune, lifeEasy \n India-411052\n"
	      		+ "\n"
	      		+ "Thank You For Banking With Us \n\n"
	      		+ "LifeEasyHomeLoan Finance Ltd.....!!!!");
		try {
			es.sendemail(emailsendtocustomer);
		} catch (Exception e2) {
			e2.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		}
		else {
			log.info("Send Rejected Mail To Customer");
			emailsendtocustomer.setFromEmail(fromEmail);
			emailsendtocustomer.setToEmail(enquirydetails.getEmail());
			emailsendtocustomer.setSubject("Regarding Home Loan For Documentation of Applicant name: "+ enquirydetails.getFirstName() +" "+ enquirydetails.getLastName());
			emailsendtocustomer.setTextBody("Dear [Customer's Name],\r\n"
					+ "\r\n"
					+ "We hope this message finds you well. We would like to inform you about the status of your recent loan application with [Bank Name]. After careful consideration and a thorough review of your application, we regret to inform you that your loan request has been declined.\r\n"
					+ "\r\n"
					+ "While we understand that this news may be disappointing, we want to assure you that our decision was made after a comprehensive assessment of your financial profile, credit history, and the information provided in your application. Unfortunately, based on our evaluation, we are unable to approve your loan at this time.\r\n"
					+ "\r\n"
					+ "We understand that obtaining financial assistance is an important matter, and we encourage you to explore alternative options or contact other financial institutions to explore potential alternatives. Additionally, please keep in mind that a loan rejection from our bank does not necessarily reflect your overall creditworthiness or financial stability.\r\n"
					+ "\r\n"
					+ "We appreciate the opportunity you gave us to consider your application, and we apologize for any inconvenience this may have caused. If you have any questions or require further clarification regarding the decision, please feel free to contact our customer service team at [Contact Number] or visit your nearest branch.\r\n"
					+ "\r\n"
					+ "We sincerely appreciate your interest in our services and wish you success in your future financial endeavors.\r\n"
					+ "\r\n"
					+ "Thank you for considering [Bank Name].\r\n"
					+ "\r\n"
					+ "Sincerely,\r\n"
					+ "\r\n"
					+ "[Branch Manager]\r\n"
					+ "[Mr.Pravin Dongare]\r\n"
					+ "[LifeEasyHomeLoan]");
			try {
				es.sendemail(emailsendtocustomer);
			} catch (Exception e2) {
				e2.printStackTrace();
				return new ResponseEntity<String>(HttpStatus.OK);
			}
			
		}
	return new ResponseEntity<String>(HttpStatus.OK);
	}

}
