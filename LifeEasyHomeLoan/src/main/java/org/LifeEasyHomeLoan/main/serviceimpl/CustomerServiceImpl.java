package org.LifeEasyHomeLoan.main.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.repository.CustomerRepository;
import org.LifeEasyHomeLoan.main.servicei.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository cr;
	@Override
	public Customer saveCustomer(Customer customerdetails) {
		
		return cr.save(customerdetails);
	}
	
	@Override
	public List<Customer> getCustomer() {
		
		return cr.findAll();
	}
	
	@Override
	public Optional<Customer> findById(Integer customerId) {
		return cr.findByCustomerId(customerId);
	}

	@Override
	public Iterable<Customer> findLoanStatus(String customerLoanStatus) {
		Iterable<Customer> customerrepo=cr.findByCustomerLoanStatus(customerLoanStatus);
		return customerrepo;
	}


	@Override
	public Customer updateCustomer(Customer singlecustomer) {
		
		return cr.save(singlecustomer);
	}




}
