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
public class PreviousLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer previousLoanId;
	private Double  previousLoanAmount;
	private Integer previousLoanTenure;
	private Double  previousLoanPaidAmount;
	private Double  previousLoanRemainingAmount;
	private String  previousLoanstatus;
	@OneToOne(cascade=CascadeType.ALL)
	private PreviousLoanBank previousLoanBankDetails;
	private String           previousLoanRemark;
}
