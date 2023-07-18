 package org.LifeEasyHomeLoan.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String  customerName;
	private String  customerDateOfBirth;
	private Integer customerAge;
	private String  customerGender;
	private Long    customerMobileNo;
	private String  customerEmail;
	private String  customerQualification;
	private Integer customerCibilScore;
	private String  customerLoanStatus;
	private Double  customerLoanAmountRequired;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocs allPersonalDoct;
	
	@OneToOne (cascade=CascadeType.ALL)
	private CustomerAddress customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Profession customerProfession;
	
	@OneToOne (cascade=CascadeType.ALL)
	private AccountDetails accountdetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyInfo propertyinfo;

	@OneToOne (cascade=CascadeType.ALL)
	private CurrentLoanDetails currentloandetails;
	
	@OneToOne (cascade=CascadeType.ALL)
	private PreviousLoan previousloan;
	
	@OneToOne (cascade=CascadeType.ALL)
	private MortgageDetails mortgageDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement customerLoanDisbursement;
	
	@OneToOne (cascade=CascadeType.ALL)
	private Ledger ledger;
	
	@OneToOne (cascade=CascadeType.ALL)
	private SanctionLetter sanctionLetter;
	
		
}
