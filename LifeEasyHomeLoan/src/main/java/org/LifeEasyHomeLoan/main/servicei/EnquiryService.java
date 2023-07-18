package org.LifeEasyHomeLoan.main.servicei;

import org.LifeEasyHomeLoan.main.model.EnquiryDetails;

public interface EnquiryService {

	public EnquiryDetails saveEnquiry(EnquiryDetails enquiryDetails);

	public EnquiryDetails getsingleEnquiry(int enquiryId);

	public EnquiryDetails getCibilEnquiryDetail(int enquiryId);

}
