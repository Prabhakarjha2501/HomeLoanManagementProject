package org.LifeEasyHomeLoan.main.servicei;

import java.io.ByteArrayInputStream;

import org.LifeEasyHomeLoan.main.model.Customer;
import org.LifeEasyHomeLoan.main.model.SanctionLetter;

public interface SanctionService {

	Iterable<Customer> getCustomerbyStatus(String customerLoanStatus);

	ByteArrayInputStream generateSactionId(Integer customerId, SanctionLetter sanctionLetter);

}
