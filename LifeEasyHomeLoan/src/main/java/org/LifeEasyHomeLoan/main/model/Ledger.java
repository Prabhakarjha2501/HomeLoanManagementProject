package org.LifeEasyHomeLoan.main.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ledgerId;
	private String  ledgerCreatedDate;
	private Double  totalLoanAmount;
	private Double  payableAmountwithInterest;
	private Integer tenure;
	private Double  monthlyEmi;
	private Double  amountPaidTillDate;
	private Double  remainingAmount;
	private String  nextEmiDateStart;
	private String  nextEmiDateEnd;
	private String  previousEmiStatus;
	private String  currentMonthEmiStatus;
	private String  loanEndDate;
	private String  loanStatus;
}
