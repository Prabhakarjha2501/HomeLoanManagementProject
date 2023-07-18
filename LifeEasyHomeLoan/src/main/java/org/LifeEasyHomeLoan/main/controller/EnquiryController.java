 package org.LifeEasyHomeLoan.main.controller;
import java.util.Random;
import org.LifeEasyHomeLoan.main.enums.EnquiryCibilStatus;
import org.LifeEasyHomeLoan.main.model.EnquiryDetails;
import org.LifeEasyHomeLoan.main.servicei.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
public class EnquiryController {
	@Autowired
	EnquiryService es;
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody EnquiryDetails enquirydetails ){
		log.info("SaveEnquiryDetails");
		enquirydetails.setCibilStatus(String.valueOf(EnquiryCibilStatus.pending));
		es.saveEnquiry(enquirydetails);
		return new ResponseEntity<String>("saveEnquiry",HttpStatus.CREATED);
	}
	
	@GetMapping("/getsingleEnquiry/{enquiryId}")
	public ResponseEntity<EnquiryDetails> getsingleEnquiry(@PathVariable int enquiryId){
		log.info("GetSingleEnquiryDetails");
		EnquiryDetails getenquirydetails = es.getsingleEnquiry(enquiryId);
		if(getenquirydetails !=null) {
			return new ResponseEntity<EnquiryDetails>(getenquirydetails,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<EnquiryDetails>(HttpStatus.BAD_REQUEST);
		}
	} 
	
	@PutMapping("/CheckCIBIL/{enquiryId}")
	public ResponseEntity<String> checkCibilScore(@PathVariable("enquiryId") int enquiryId,@RequestBody EnquiryDetails checkCIBIL)
	{	log.info("CheckCibilDetails");
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(600) + 300;
		
		if(cibilScore>=300 && cibilScore<=900) 
		{
			checkCIBIL.setCibilStatus(String.valueOf(EnquiryCibilStatus.approved));
			checkCIBIL.setCibilScore(cibilScore);
		    EnquiryDetails updateEnquiryDetails = es.saveEnquiry(checkCIBIL);
			return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		else
		{
			checkCIBIL.setCibilStatus(String.valueOf(EnquiryCibilStatus.rejected));
			checkCIBIL.setCibilScore(cibilScore);
			EnquiryDetails updateEnquiryDetails = es.saveEnquiry(checkCIBIL);			
		}
		return new ResponseEntity<String>("Rejected",HttpStatus.OK);
	}
	
	@GetMapping("/getcibil/{enquiryId}")
	public ResponseEntity<EnquiryDetails> getEnquiry(@PathVariable int enquiryId){
		
		log.info("GetCibilDetails");
		EnquiryDetails cibilDeatails = es.getCibilEnquiryDetail(enquiryId);
		if(cibilDeatails !=null) {
			return new ResponseEntity<EnquiryDetails>(cibilDeatails,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<EnquiryDetails>(HttpStatus.BAD_REQUEST);
		}
	} 
	
	
	
}
