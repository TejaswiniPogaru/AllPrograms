package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client {
	public static void main(String[] args) {
		WalletService service;
		{
			service = new WalletServiceImpl();
		}
		Customer customer = new Customer();
		Scanner scan = new Scanner(System.in);
		String ans;
		int choice;
		do {
			System.out.println("****Welcome to Walletapp of XYZ Bank");
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit Amount");
			System.out.println("4. WithDraw Amount");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Exit");
			System.out.println("Please enter the choice");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Please Enter the Name");
				String userName = scan.next();
				System.out.println("Please Enter the Mobile Number");
				String mobileNumber = scan.next();
				System.out.println("Please Enter the amount");
				BigDecimal amount = scan.nextBigDecimal();
				customer = service.createAccount(userName, mobileNumber, amount);
				System.out.println("Successfully Created the account");
				System.out.println(customer);
				break;
			case 2:
				System.out.println("Please enter the mobile number for balance amount");
				String mobileno = scan.next();
				customer = service.showBalance(mobileno);
				System.out.println("Your balance of Mobile Number"+mobileno+"is"+customer.getWallet());
				break;
			case 3:
				System.out.println("Please Enter the mobile Number");
				String mobileNo = scan.next();
				System.out.println("please Enter the amount for deposition");
				BigDecimal amount1 = scan.nextBigDecimal();
				customer = service.depositAmount(mobileNo, amount1);
				System.out.println(customer);
				break;
			case 4:
				System.out.println("Please Enter Mobile Number");
				String mobileNum = scan.next();
				System.out.println("please enter amount to withdraw");
				BigDecimal amount2 = scan.nextBigDecimal();
				customer = service.withdrawAmount(mobileNum, amount2);
				System.out.println(customer);
				break;
			case 5:
				System.out.println("Please enter the Source Mobile Number");
				String sourceMobileNo = scan.next();
				System.out.println("Please Enter the amount to transfer");
				BigDecimal amount3 = scan.nextBigDecimal();
				System.out.println("Please enter the destination Mobile Number");
				String destinatonMobileNo = scan.next();
				customer = service.fundTransfer(sourceMobileNo, destinatonMobileNo, amount3);
				System.out.println(customer);
				break;
			case 6:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid choice");
					break;
			}
			
			
			System.out.println("Do you want to continue?");
			ans = scan.next();
		}while(ans.equals("Yes")||ans.equals("YES")||ans.equals("Y")||ans.equals("y"));
	}
}
