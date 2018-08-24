package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {

	private WalletRepo serviceRepo;
	public WalletServiceImpl(Map<String, Customer> data){
		serviceRepo= new WalletRepoImpl(data);
	}

	public WalletServiceImpl() {
		serviceRepo = new WalletRepoImpl();
	}

	public WalletServiceImpl(WalletRepo repo) {
		super();
		this.serviceRepo = repo;
	}

	WalletRepoImpl obj = new WalletRepoImpl();

	public Customer createAccount(String name, String mobileNo, BigDecimal amount) {
		Customer customer = new Customer(name, mobileNo, new Wallet(amount));
		acceptCustomerDetails(customer);
		boolean status = serviceRepo.save(customer);
		if (status == true)
			return customer;
		else
			return null;

	}

	public Customer showBalance(String mobileNo) {
		Customer customer = serviceRepo.findOne(mobileNo);
		if (customer != null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no ");
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		customer = serviceRepo.findOne(mobileNo);
		if (customer != null) {
			BigDecimal depositAmount = customer.getWallet().getBalance().add(amount);
			wallet.setBalance(depositAmount);
			customer.setWallet(wallet);
			obj.getData().put(mobileNo, customer);
		}
		return customer;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException {
		Customer customer1 = new Customer();
		Wallet wallet1 = new Wallet();
		customer1 = serviceRepo.findOne(mobileNo);
		
		if(customer1!=null)
		{
			BigDecimal bal=customer1.getWallet().getBalance();
			BigDecimal amtSub;
			if(bal.compareTo(amount)>0)
			{
				amtSub=bal.subtract(amount);
				wallet1.setBalance(amtSub);
				customer1.setWallet(wallet1);
				obj.getData().put(mobileNo, customer1);
			}
			else
			{
				System.err.println("Insufficient Balance! Sry Amount Cannot be Withdraw");
			}
			
		}
		return customer1;

	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		Customer sCustomer = new Customer();
		Customer tCustomer = new Customer();
		Wallet sWallet = new Wallet();
		Wallet tWallet = new Wallet();
		sCustomer = serviceRepo.findOne(sourceMobileNo);
		tCustomer = serviceRepo.findOne(targetMobileNo);
		if (sCustomer != null && tCustomer != null) {
			BigDecimal bal = sCustomer.getWallet().getBalance();
			if (bal.compareTo(amount) > 0) {
				BigDecimal diff = bal.subtract(amount);
				sWallet.setBalance(diff);
				sCustomer.setWallet(sWallet);

				BigDecimal baladd = tCustomer.getWallet().getBalance();
				BigDecimal sum = baladd.add(amount);
				tWallet.setBalance(sum);
				tCustomer.setWallet(tWallet);

				obj.getData().put(targetMobileNo, tCustomer);
				obj.getData().put(sourceMobileNo, sCustomer);
			} else {
				System.err.println("Insufficient Balance.Amount Cannot Be Withdraw");
			}
		}
		return tCustomer;
	}
	public void acceptCustomerDetails(Customer cust)  {
		Scanner scan=new Scanner(System.in);
		while (true) {
			String str=cust.getMobileNo();
			if(validatephone(str))//method validate name
			{
				
				break;
			}
			else
			{
				System.err.println("Wrong Phone number!!\n Please Start with 9 ");
				System.out.println("Enter Phone number Again eg:9876543210");
				cust.setMobileNo(scan.next());
			}
		}
		while (true) {
			String str1=cust.getName();
			if(validateName(str1))//method validate name
			{
				break;
			}
			else
			{
				System.err.println("Wrong  Name!!\n Please Start with Capital letter ");
				System.out.println("Enter  Name Again eg:Name");
				cust.setName(scan.next());
			}
		}
	}

	public boolean validatephone(String phoneno) {

		String pattern1 = "[7-9]?[0-9]{10}";
		if (phoneno.matches(pattern1)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateName(String pName) {
		String pattern = "[A-Z][a-zA-Z]*";
		if (pName.matches(pattern)) {
			return true;
		} else {
			return false;
		}
	}

}
