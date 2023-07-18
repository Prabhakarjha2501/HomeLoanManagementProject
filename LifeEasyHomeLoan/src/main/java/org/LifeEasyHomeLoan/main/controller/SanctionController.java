package org.LifeEasyHomeLoan.main.controller;

import java.io.ByteArrayInputStream;

import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.model.SanctionLetter;
import org.LifeEasyHomeLoan.main.servicei.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SanctionController {
	
	@Autowired
	SanctionService ss;
	@GetMapping("/getCustomer/{customerLoanStatus}")	//get customer by loan status
	public ResponseEntity<Iterable<Customer>> getCustomerByStatus(
			@PathVariable("customerLoanStatus") String customerLoanStatus) {
		Customer cstd = null;
		Iterable<Customer> cst = ss.getCustomerbyStatus(customerLoanStatus);
		for (Customer cstds : cst) {
			if (cstds != null) {
				cstd = cstds;
			}
		}
		if (cstd != null) {
			
			return new ResponseEntity<Iterable<Customer>>(cst,HttpStatus.OK);
		} else {
			throw new NullPointerException();
		}
	}
	
	
	@PutMapping("/generatePdf/{customerId}")
	public ResponseEntity<InputStreamResource> updateSactionLetter(@PathVariable("customerId") Integer customerId, @RequestBody SanctionLetter sanctionLetter) {
	
		Customer customerdetail = new Customer();
		
		ByteArrayInputStream customerdetails = ss.generateSactionId(customerId, sanctionLetter);
		 HttpHeaders headers=new HttpHeaders();
	      headers.add("Content-Disposition", "inline; filename=homeloan_sanctionLatter.pdf");		
	
		return  ResponseEntity.ok().headers(headers)
				.contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(customerdetails));

	}
	

}
