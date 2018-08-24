package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
@Embeddable
public class Wallet {	
		private BigDecimal balance;

		public Wallet(BigDecimal amount) {
			super();
			this.balance=amount;
		}
		

		public Wallet() {
			super();
			
		}


		public BigDecimal getBalance() {
			return balance;
		}

		public  void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		@Override
			public String toString() {
			return ", balance="+balance;
		}

}
