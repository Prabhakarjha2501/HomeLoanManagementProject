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
public class PropertyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId;
	private String  propertyType;
	private String  propertyArea;
	private String  constructionArea;
	private Double  propertyPrice;
	private Double  constrctionPrice;
}
