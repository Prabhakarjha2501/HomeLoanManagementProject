package org.LifeEasyHomeLoan.main.controller;

import java.io.IOException;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.enums.CustomerLoanStatus;
import org.LifeEasyHomeLoan.main.exception.CustomerNotFoundException;
import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.model.LoanDisbursement;
import org.LifeEasyHomeLoan.main.servicei.LoanDisbursementservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/loandis")
public class LoanDisbursementController {
	@Autowired
	LoanDisbursementservice ldm;
	
	@PutMapping("/loanDisbursementupdate/{customerId}")
	public ResponseEntity<Customer> updateLoan(@RequestBody LoanDisbursement loandisbursement,
			@PathVariable("customerId") Integer customerId) throws IOException {
		
	Optional<Customer> op = ldm.finddById(customerId);
	
		Customer customerdata= op.get();
		if(op.isPresent()) {
		 customerdata.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.LoanDisbursed));
		 		 
		 customerdata.getCustomerLoanDisbursement().setLoanNo(loandisbursement.getLoanNo());
		 customerdata.getCustomerLoanDisbursement().setAgreementDate(loandisbursement.getAgreementDate());
		customerdata.getCustomerLoanDisbursement().setAmountPayType(loandisbursement.getAmountPayType());
		customerdata.getCustomerLoanDisbursement().setTotalAmount(loandisbursement.getTotalAmount());
		customerdata.getCustomerLoanDisbursement().setBankName(loandisbursement.getBankName());
		customerdata.getCustomerLoanDisbursement().setAccountNumber(loandisbursement.getAccountNumber());
		customerdata.getCustomerLoanDisbursement().setIfsccode(loandisbursement.getIfsccode());
		customerdata.getCustomerLoanDisbursement().setAccountType(loandisbursement.getAccountType());
		customerdata.getCustomerLoanDisbursement().setTransferAmount(loandisbursement.getTransferAmount());
		customerdata.getCustomerLoanDisbursement().setPaymentStatus(loandisbursement.getPaymentStatus());
		customerdata.getCustomerLoanDisbursement().setAmountPaidDate(loandisbursement.getAmountPaidDate());
		Customer customerdetails = ldm.updateloanDisbursement(customerdata);
		
		return ResponseEntity.ok(customerdata);
		}
		else {
			throw new CustomerNotFoundException(customerId);
		}
	
	}
}
