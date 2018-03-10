package com.helloworld.jpa.model;

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
@Table(name = "customber_info")
public class CustomberEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "customber_Id")
	private int customberId;
	@Column(name = "first_name",nullable=false)
	private String firstName;
	@Column(name = "last_ame",nullable=false)
	private String lastName;
	@Column(name = "address",nullable=false)
	private String address;
	@Column(name = "phone_number",nullable=false, length=11)
	private long phoneNumber;
	@OneToMany(mappedBy = "customberEntity",cascade = CascadeType.ALL)
	private Set<TransactionEntity> transactionEntities; 

	public CustomberEntity() {

	}

	public CustomberEntity(int customberId, String firstName, String lastName, String address, long phoneNumber,
			Set<TransactionEntity> transactionEntities) {
		this.customberId = customberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.transactionEntities = transactionEntities;
	}

	public CustomberEntity(String firstName, String lastName, String address, long phoneNumber,
			Set<TransactionEntity> transactionEntities) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.transactionEntities = transactionEntities;
	}
	public int getCustomberId() {
		return customberId;
	}

	public void setCustomberId(int customberId) {
		this.customberId = customberId;
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
		result = prime * result + customberId;
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
		CustomberEntity other = (CustomberEntity) obj;
		if (customberId != other.customberId)
			return false;
		return true;
	}

}
