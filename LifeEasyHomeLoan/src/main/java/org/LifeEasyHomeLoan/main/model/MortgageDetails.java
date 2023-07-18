package org.LifeEasyHomeLoan.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MortgageDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mortgageId;
	private Double 	mortgagePropertyValue;
	private String 	BorrowerName;
	private String 	PropertyAddress;
	private Double 	LoanAmount;
	private Integer loanTerm;
}
