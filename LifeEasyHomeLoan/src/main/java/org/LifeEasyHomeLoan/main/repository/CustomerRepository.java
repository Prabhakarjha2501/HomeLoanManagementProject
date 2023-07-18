package org.LifeEasyHomeLoan.main.repository;
import java.util.Optional;

import org.LifeEasyHomeLoan.main.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByCustomerId(Integer customerId);
	public Iterable<Customer> findByCustomerLoanStatus(String customerLoanStatus);
	
	
}
