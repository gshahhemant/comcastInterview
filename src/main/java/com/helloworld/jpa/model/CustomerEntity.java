package com.helloworld.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_info")
public class CustomerEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "customer_Id")
	private int customerId;
	@Column(name = "first_name",nullable=false)
	private String firstName;
	@Column(name = "last_ame",nullable=false)
	private String lastName;
	@Column(name = "address",nullable=false)
	private String address;
	@Column(name = "phone_number",nullable=false, length=11)
	private long phoneNumber;
	@OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
	private Set<TransactionEntity> transactionEntities = new HashSet<TransactionEntity>(); 

	public CustomerEntity() {

	}

	public CustomerEntity(int customerId, String firstName, String lastName, String address, long phoneNumber,
			Set<TransactionEntity> transactionEntities) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.transactionEntities = transactionEntities;
	}
	
	public CustomerEntity(String firstName, String lastName, String address, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public CustomerEntity(String firstName, String lastName, String address, long phoneNumber,
			Set<TransactionEntity> transactionEntities) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.transactionEntities = transactionEntities;
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomberId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<TransactionEntity> getTransactions() {
		return transactionEntities;
	}

	public void setTransactions(Set<TransactionEntity> transactionEntities) {
		this.transactionEntities = transactionEntities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
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
		CustomerEntity other = (CustomerEntity) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

}
