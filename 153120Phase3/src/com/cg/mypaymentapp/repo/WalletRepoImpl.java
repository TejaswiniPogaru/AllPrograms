package com.cg.mypaymentapp.repo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data; 
	{
		data = new HashMap<>();
	}
	
	public Map<String, Customer> getData() {
		return data;
	}

	public void setData(Map<String, Customer> data) {
		this.data = data;
	}
	Customer cust = new Customer();
	public WalletRepoImpl(Map<String, Customer> data) {
	super();
	this.data = data;
}
	public WalletRepoImpl() {
		
	}
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("153120Phase2");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		tx.begin();
		em.persist(customer);
		tx.commit();
		return true;
		
	}
	@Override
	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		Customer e=new Customer();
		tx.begin();
		em.persist(cust);
		e=em.find(Customer.class,mobileNo);
		tx.commit();
			return e;
	}
	@Override
	public Customer updateBal(Customer customer) {
		// TODO Auto-generated method stub
		EntityManager em1=emf.createEntityManager();
		tx.begin();
		Customer cust1=(Customer)em1.merge(customer);
		em1.persist(cust1);
		tx.commit();
		em1.close();
		return customer;
	}
	


	

}
