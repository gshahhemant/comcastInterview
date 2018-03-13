package com.helloworld.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_detail")
public class TransactionEntity implements Serializable{

	private static final long serialVersionUID = -6426603128136040022L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_Id")
	private long transactionId;
	@Column(name = "transaction_name",nullable=false)
	private String transactionName;
	@Column(name = "amount",nullable=false)
	private double amount;
	@ManyToOne()
	@JoinColumn(name = "customer_Id")
	private CustomerEntity customerEntity;


	public TransactionEntity() {

	}
	public TransactionEntity(long transactionId, String transactionName, double amount, CustomerEntity customerEntity) {
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.amount = amount;
		this.customerEntity = customerEntity;
	}
	public TransactionEntity(String transactionName, double amount, CustomerEntity customerEntity) {
		this.transactionName = transactionName;
		this.amount = amount;
		this.customerEntity = customerEntity;
	}
	public TransactionEntity(String transactionName, double amount) {
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
	public CustomerEntity getCustomer() {
		return customerEntity;
	}
	public void setCustomer(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
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
		TransactionEntity other = (TransactionEntity) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

}
