package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer {
	private String name;
	@Id
	private String mobileNo;
	@Embedded
	private Wallet wallet;
	public Customer(String name2, String mobileNo2, Wallet wallet2) {
		this.name=name2;
		this.mobileNo=mobileNo2;
		this.wallet=wallet2;
}
	public Customer() {
		// TODO Auto-generated constructor stub
		this.name="Capgemini";
		this.mobileNo="9866317016";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo
				 + wallet;
	}
	

}
