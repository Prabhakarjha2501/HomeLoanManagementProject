package org.LifeEasyHomeLoan.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionId;
	private String sanctionDate;
	private String applicantName;
	private Double contactDetails;
	private String productHomeEquity;
	private Double loanAmtsanctioned;
	private String intrestType;
	private Integer rateOfIntrest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	@Lob
	private byte[] sanctionLetter;
}
