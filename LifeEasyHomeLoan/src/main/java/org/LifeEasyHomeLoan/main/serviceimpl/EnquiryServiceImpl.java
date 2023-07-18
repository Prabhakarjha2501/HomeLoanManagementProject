package org.LifeEasyHomeLoan.main.serviceimpl;

import org.LifeEasyHomeLoan.main.model.EnquiryDetails;
import org.LifeEasyHomeLoan.main.repository.EnquiryRepository;
import org.LifeEasyHomeLoan.main.servicei.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnquiryServiceImpl implements EnquiryService {
	@Autowired
	EnquiryRepository er;
	@Override
	public EnquiryDetails saveEnquiry(EnquiryDetails enquiryDetails) {
		
		return er.save(enquiryDetails);
	}
	@Override
	public EnquiryDetails getsingleEnquiry(int enquiryId) {
		return er.findAllByenquiryId(enquiryId);
	}
	@Override
	public EnquiryDetails getCibilEnquiryDetail(int enquiryId) {
		
		return er.findAllByenquiryId(enquiryId);
	}

}
