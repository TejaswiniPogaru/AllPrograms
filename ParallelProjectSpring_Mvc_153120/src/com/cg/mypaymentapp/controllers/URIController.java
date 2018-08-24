package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController {
	@RequestMapping("/")
	public String getIndexPage() {
		return "indexpage";
		
	}
	@RequestMapping("/registrationPage")
	public String getRegistrationPage() {
		return "registrationPage";
	}
	@RequestMapping("/loginPage")
	public String getLoginPage() {
		return "LoginPage";
	}
	@RequestMapping("/deposit")
	public String getDepositPage() {
		return "depositPage";
	}
	@RequestMapping("/withdraw")
	public String getWithDrawPage() {
		return "withDrawPage";
	}
	@RequestMapping("/fundTransfer")
	public String getFundTransferPage() {
		return "fundTransferPage";
	}
	@ModelAttribute("customer")
	public Customer getCustomer()
	{
		return new Customer();
	}
	

}
