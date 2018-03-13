package com.helloworld.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Customer implements Serializable{

	
	private static final long serialVersionUID = -2004518066580690715L;
	private int customberId;
	private CustomerInfo customerInfo;
    private Set<Transaction> transactions = new HashSet<Transaction>();
    
   	public Customer() {
	
   	}
	public int getCustomberId() {
		return customberId;
	}
	public void setCustomberId(int customberId) {
		this.customberId = customberId;
	}
	public CustomerInfo getCustomberInfo() {
		return customerInfo;
	}
	public void setCustomberInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	} 

}
