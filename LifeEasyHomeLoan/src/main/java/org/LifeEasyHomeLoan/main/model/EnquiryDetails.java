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
public class EnquiryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enquiryId;//customerId
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private Long mobileNumber;
	private Long pancardNumber;
	private String cibilStatus;
	private Integer cibilScore;
}
