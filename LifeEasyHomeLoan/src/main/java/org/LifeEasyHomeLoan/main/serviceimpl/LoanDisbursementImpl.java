package org.LifeEasyHomeLoan.main.serviceimpl;
import java.util.Optional;
import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.repository.CustomerRepository;
import org.LifeEasyHomeLoan.main.servicei.LoanDisbursementservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanDisbursementImpl implements LoanDisbursementservice{
@Autowired
CustomerRepository cr;
	@Override
	public Optional<Customer> finddById(Integer customerId) {
		
		return cr.findById(customerId);
	}
	@Override
	public Customer updateloanDisbursement(Customer customerdata) {
	
		return cr.save(customerdata);
	}
	

	
	
	
}		
	
		


