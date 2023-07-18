package org.LifeEasyHomeLoan.main.servicei;

import java.util.Optional;

import org.LifeEasyHomeLoan.main.model.Customer;


public interface LoanDisbursementservice {

	Optional<Customer> finddById(Integer customerId);

	Customer updateloanDisbursement(Customer customerdata);

	

	

}
