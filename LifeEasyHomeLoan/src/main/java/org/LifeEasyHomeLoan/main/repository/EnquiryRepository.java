package org.LifeEasyHomeLoan.main.repository;

import org.LifeEasyHomeLoan.main.model.EnquiryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryDetails, Integer>{
	public EnquiryDetails findAllByenquiryId(int enquiryId);
}
