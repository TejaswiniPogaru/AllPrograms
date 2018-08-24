package com.cg.mypaymentapp.service;

import java.math.BigDecimal;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;

public interface WalletService {
	/*public Customer createAccount(String name ,String mobileno, BigDecimal amount);
	public Customer showBalance (String mobileno);
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount);
	public Customer depositAmount (String mobileNo,BigDecimal amount );
	public Customer withdrawAmount(String mobileNo, BigDecimal amount);
	public void acceptCustomerDetails(Customer customer);*/
	public Customer createAccount(Customer customer) throws InvalidInputException ;

	public Customer showBalance(String mobileNo)throws InvalidInputException;

	public Customer depositAmount(String mobileNo, BigDecimal amount);

	public Customer withDrawAmount(String mobileNo, BigDecimal balance);

	

	public Customer fundTransfer(String sourcemobileNo, String targetmobileNo, BigDecimal balance);
	

}
