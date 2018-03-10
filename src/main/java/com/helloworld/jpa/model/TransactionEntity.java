package com.helloworld.jpa.model;

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
public class TransactionEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_Id")
	private long transactionId;
	@Column(name = "transaction_name",nullable=false)
	private String transactionName;
	@Column(name = "amount",nullable=false)
	private double amount;
	@ManyToOne()
	@JoinColumn(name = "customber_Id")
	private CustomberEntity customberEntity;
			
	
	public TransactionEntity() {
		
	}
	public TransactionEntity(long transactionId, String transactionName, double amount, CustomberEntity customberEntity) {
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.amount = amount;
		this.customberEntity = customberEntity;
	}
	public TransactionEntity(String transactionName, double amount, CustomberEntity customberEntity) {
		this.transactionName = transactionName;
		this.amount = amount;
		this.customberEntity = customberEntity;
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
	public CustomberEntity getCustomer() {
		return customberEntity;
	}
	public void setCustomer(CustomberEntity customberEntity) {
		this.customberEntity = customberEntity;
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
