package org.LifeEasyHomeLoan.main.exception;

public class CustomerNotFoundException extends RuntimeException{

	
	private long LoanId;
	public CustomerNotFoundException(long LoanId ) {
		super(String.format("this id is not found:%s",LoanId));
		this.LoanId=LoanId;
	}
	
}
