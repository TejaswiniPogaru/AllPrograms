package com.cg.mypaymentapp.service;



import java.math.BigDecimal;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService {
@Autowired
private WalletRepo repoService;
@Transactional	
	@Override
	public Customer createAccount(Customer customer) throws InvalidInputException {
		// TODO Auto-generated method stub
		return repoService.save(customer);
	}
@Transactional
@Override
public Customer showBalance(String mobileNo) throws InvalidInputException {
	// TODO Auto-generated method stub
	Customer customer  = repoService.findOne(mobileNo);
	if(customer==null )
		throw new InvalidInputException("Invalid mobile no ");
	else return customer;
}
@Transactional
@Override
public Customer depositAmount(String mobileNo, BigDecimal amount) {
	// TODO Auto-generated method stub
	 Customer customer=new Customer();
	 Wallet wallet = new Wallet();
	 //customer = repoService.findOne(mobileNo);
	 ArrayList<Customer> list = new ArrayList<>();
	 list= (ArrayList<Customer>) repoService.findAll();
	 //System.out.println(list);
	 
	 for (Customer customer2 : list) 
	 {
		 if(mobileNo.equals(customer2.getMobileNo()))
		 {
			 //System.out.println("inside if");
			 BigDecimal depositAmount = customer2.getWallet().getBalance().add(amount);
				wallet.setBalance(depositAmount);
				customer2.setWallet(wallet);
				//System.out.println("*****************"+customer);
				Customer cust= repoService.save(customer2);
				return cust;
		 }
	}
	 
	
	 		

	return null;
	 
}
@Transactional
@Override
public Customer withDrawAmount(String mobileNo, BigDecimal amount) {
	// TODO Auto-generated method stub
	Customer customer=new Customer();
	 Wallet wallet = new Wallet();
	 ArrayList<Customer> list = new ArrayList<>();
	 list= (ArrayList<Customer>) repoService.findAll();
	 for (Customer customer2 : list) 
	 {
		 if(mobileNo.equals(customer2.getMobileNo()))
		 {
			 //System.out.println("inside if");
			 BigDecimal withDrawAmount = customer2.getWallet().getBalance().subtract(amount);
				wallet.setBalance(withDrawAmount);
				customer2.setWallet(wallet);
				//System.out.println("*****************"+customer);
				Customer cust= repoService.save(customer2);
				return cust;
		 }
	}
	 
	
	return null;
}
@Transactional
@Override
public Customer fundTransfer(String sourcemobileNo, String targetmobileNo, BigDecimal balance) {
	// TODO Auto-generated method stub
	Customer sCustomer = new Customer();
	Customer tCustomer = new Customer();
	Wallet sWallet = new Wallet();
	Wallet tWallet = new Wallet();
	sCustomer = repoService.findOne(sourcemobileNo);
	tCustomer = repoService.findOne(targetmobileNo);
	if (sCustomer != null && tCustomer != null) {
		BigDecimal bal = sCustomer.getWallet().getBalance();
		if (bal.compareTo(balance) > 0) {
			BigDecimal diff = bal.subtract(balance);
			sWallet.setBalance(diff);
			sCustomer.setWallet(sWallet);

			BigDecimal baladd = tCustomer.getWallet().getBalance();
			BigDecimal sum = baladd.add(balance);
			tWallet.setBalance(sum);
			tCustomer.setWallet(tWallet);

			/*obj.getData().put(targetmobileNo, tCustomer);
			obj.getData().put(sourcemobileNo, sCustomer);*/
			Customer scust = repoService.save(sCustomer);
			Customer tcust = repoService.save(tCustomer);
		} 
		else {
			System.err.println("Insufficient Balance.Amount Cannot Be Withdraw");
		}
		}	
		else {
			throw new InvalidInputException("Account Doesn't Exit");
	}
	return sCustomer;
	
}

}
