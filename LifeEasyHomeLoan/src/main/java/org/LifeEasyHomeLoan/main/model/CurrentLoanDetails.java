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
public class CurrentLoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currentLoanId;
	private Integer currentLoanNo;
	private Double  currentLoanAmmount;
	private Integer rateOfInterest;
	private Integer tenure;
	private Double  totalAmountToBePaid;
	private Integer processingFees;
	private Double  totalInterest;
	private String  sanctionDate;
	private String  remarks;
	@OneToOne(cascade = CascadeType.ALL)
	private EMIDetails emidetails;
	private String Status;
}
