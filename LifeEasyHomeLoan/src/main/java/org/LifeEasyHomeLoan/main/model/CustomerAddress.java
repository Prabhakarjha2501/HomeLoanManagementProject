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
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerPermanentAddressId;
	private String  areaname;
	private String  streetname;
	private String  cityname;
	private String  district;
	private String  subDistrict;
	private String  state;
	private Long    pincode;
	private Integer houseNo;
}
