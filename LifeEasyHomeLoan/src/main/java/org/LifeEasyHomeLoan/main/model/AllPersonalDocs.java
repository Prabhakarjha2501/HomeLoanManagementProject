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
public class AllPersonalDocs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer documentId;
	private String status;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] panCard;
	@Lob
	private byte[]	aadharCard;
	@Lob
	private byte[] signature;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] incometax;
	@Lob
	private byte[] salaryslip;
	@Lob
	private byte[] bankcheque;
}
