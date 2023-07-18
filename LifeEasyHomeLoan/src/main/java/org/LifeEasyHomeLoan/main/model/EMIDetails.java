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
public class EMIDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emiId;
	private Double  emimonthlyAmount;
	private String  nextEmidueDate;
	private String  previousEmiStatus;
}
