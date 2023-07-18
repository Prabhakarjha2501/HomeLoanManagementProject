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
public class AccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerAccountId;
	private Long    customerAccountNumber;
	private String  customerAccountHolderName;
	private String  customerBankBranchName;
	private String  customerBankIfscNumber;
	
}
