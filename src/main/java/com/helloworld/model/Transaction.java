package com.helloworld.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class Transaction implements Serializable{

	private static final long serialVersionUID = 5754973241517736329L;
	private long transactionId;
	private String transactionName;
	private double amount;
	
					
	public Transaction() {
		
	}
	public Transaction(long transactionId, String transactionName, double amount) {
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.amount = amount;
	
	}
	public Transaction(String transactionName, double amount) {
		this.transactionName = transactionName;
		this.amount = amount;
		
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
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
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionName=" + transactionName + ", amount="
				+ amount + "]";
	}
}
