 package org.LifeEasyHomeLoan.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.enums.CustomerLoanStatus;
import org.LifeEasyHomeLoan.main.model.AllPersonalDocs;
import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.servicei.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cs;
	@PostMapping(value="/saveCustomer", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)//post all data with multipart file
	public ResponseEntity<String> SaveCustomer(@RequestPart("allData") String allData,
			@RequestPart("addressProof") MultipartFile file1, @RequestPart("panCard") MultipartFile file2,
			@RequestPart("aadharCard") MultipartFile file3, @RequestPart("signature") MultipartFile file4,
			@RequestPart("photo") MultipartFile file5, @RequestPart("incometax") MultipartFile file6,
			@RequestPart("salaryslip") MultipartFile file7, @RequestPart("bankcheque") MultipartFile file8){
		
			ObjectMapper om=new ObjectMapper();
		   
				try {
					Customer customerdetails = om.readValue(allData, Customer.class);
					if (customerdetails.getAllPersonalDoct() == null) {
					    customerdetails.setAllPersonalDoct(new AllPersonalDocs());
					}
					customerdetails.getAllPersonalDoct().setAddressProof(file1.getBytes());
					customerdetails.getAllPersonalDoct().setPanCard(file2.getBytes());
					customerdetails.getAllPersonalDoct().setAadharCard(file3.getBytes());
					customerdetails.getAllPersonalDoct().setSignature(file4.getBytes());
					customerdetails.getAllPersonalDoct().setPhoto(file5.getBytes());
					customerdetails.getAllPersonalDoct().setIncometax(file6.getBytes());
					customerdetails.getAllPersonalDoct().setSalaryslip(file7.getBytes());
					customerdetails.getAllPersonalDoct().setBankcheque(file8.getBytes());
					customerdetails.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.pending));
					Customer saveCustomer = cs.saveCustomer(customerdetails);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		return new ResponseEntity<String>("saveCustomerDetails",HttpStatus.CREATED);
	}
	
	  @GetMapping("/getAllCustomer")
	    public ResponseEntity<List<Customer>> getAllCustomer() {
	        List<Customer> customers = cs.getCustomer();
	        if (customers != null) {
	            return new ResponseEntity<>(customers, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	
	  @GetMapping("/getsinglecustomer/{customerId}")
	  public ResponseEntity<Customer> getSingleCustomer(@PathVariable Integer customerId) {
	      Optional<Customer> optionalCustomer = cs.findById(customerId);
	      
	      if (optionalCustomer.isPresent()) {
	          Customer customer = optionalCustomer.get();
	          return new ResponseEntity<>(customer, HttpStatus.OK);
	      } else {
	    	  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	      }
	  }
	  
	 @GetMapping("/loanstatus/{customerLoanStatus}")
	  public ResponseEntity<Iterable<Customer>>findbystatus(@PathVariable String customerLoanStatus){
		  
		  Iterable<Customer> loanStatus=cs.findLoanStatus(customerLoanStatus);
		  
		  return new ResponseEntity<>(loanStatus, HttpStatus.OK);
	  }

	 
	 @GetMapping(value ="/updateCustomer/{customerId}/{loanStatus}")
	 public ResponseEntity<String> updateCustomer(@PathVariable String loanStatus,
	                                              @PathVariable("customerId") Integer customerId) throws IOException {
	     Optional<Customer> customerDetails = cs.findById(customerId);

	     if (customerDetails.isPresent()) {
	         Customer customer = customerDetails.get();
	         
	         if (loanStatus.equals("documentverfied")) {
	             customer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentVerified));
	             cs.updateCustomer(customer);
	         } else if (loanStatus.equals("documentrejected")) {
	             customer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentRejected));
	             cs.updateCustomer(customer);
	         } else {
	             return new ResponseEntity<>("Invalid loan status value", HttpStatus.BAD_REQUEST);
	         }
	         return new ResponseEntity<>("Customer loan status updated successfully", HttpStatus.OK);
	     } else {
	        
	     }
		return null;
	 }



	
}
