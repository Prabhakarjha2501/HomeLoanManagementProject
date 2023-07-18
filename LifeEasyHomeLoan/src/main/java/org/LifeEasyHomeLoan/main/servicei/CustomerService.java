package org.LifeEasyHomeLoan.main.servicei;

import java.util.List;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.model.Customer;

public interface CustomerService {
	public Customer saveCustomer(Customer customerdetails);
	public List<Customer> getCustomer();
	public Optional<Customer> findById(Integer customerId);
	public Iterable<Customer> findLoanStatus(String customerLoanStatus);
	public Customer updateCustomer(Customer singlecustomer);
	
	
}
