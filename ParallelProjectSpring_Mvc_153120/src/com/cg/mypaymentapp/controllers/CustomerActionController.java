package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {
	@Autowired(required=true)
	private WalletService walletService;
	@RequestMapping(value="/registerCustomer",method=RequestMethod.POST)
	
	public ModelAndView registercustomer(@Valid@ModelAttribute("customer") Customer customer,BindingResult result) {
		if(result.hasErrors())
			return new ModelAndView("registrationPage");
		customer = walletService.createAccount(customer);
		ModelAndView modelAndView = new ModelAndView("registrationSuccessPage","customer",customer);
		return modelAndView;
		
		
	}
	@RequestMapping(value="/loginCustomer",method=RequestMethod.POST)
	public ModelAndView loginCustomer(@ModelAttribute("customer")Customer customer) {
		String mobileNo = customer.getMobileNo();
			customer=walletService.showBalance(mobileNo);
		return new ModelAndView("loginSuccessPage", "customer",customer);
		
	}
	@RequestMapping(value="/depositAmount")
	public ModelAndView depositAmount(@ModelAttribute("customer")Customer customer) {
		
		//System.out.println("inside da");
		//System.out.println(customer.getMobileNo()+"&&&&&&&&&&&");
		 customer=walletService.depositAmount(customer.getMobileNo(),customer.getWallet().getBalance());
		
		ModelAndView modelAndView = new ModelAndView("currentBalancePage", "customer",customer);
		return modelAndView;
		
	}
	@RequestMapping(value="/withDrawAmount",method=RequestMethod.POST)
	public ModelAndView withDrawAmount(@ModelAttribute("customer")Customer customer) {
		
		//System.out.println("inside da");
		//System.out.println(customer.getMobileNo()+"&&&&&&&&&&&");
		 customer=walletService.withDrawAmount(customer.getMobileNo(),customer.getWallet().getBalance());
		
		ModelAndView modelAndView = new ModelAndView("currentBalancePage", "customer",customer);
		return modelAndView;
		
	}
	@RequestMapping(value="/fundTransferAction",method=RequestMethod.POST)
	public ModelAndView FundTransferAction(@RequestParam("sourcemobileNo")String sourcemobileNo,@RequestParam("targetmobileNo")String targetmobileNo,@RequestParam("amount")BigDecimal amount) {
		Customer customer=walletService.fundTransfer(sourcemobileNo,targetmobileNo, amount);
		ModelAndView modelAndView = new ModelAndView("currentBalancePage", "customer",customer);
		return modelAndView;
		
		//System.out.println("inside da");
		//System.out.println(customer.getMobileNo()+"&&&&&&&&&&&");
		 
		
	}
	
}

