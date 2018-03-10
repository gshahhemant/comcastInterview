package com.helloworld.model;

import java.util.HashSet;
import java.util.Set;


public class Customber {


	private int customberId;
	private String firstName;
	private String lastName;
	private String address;
	private long phoneNumber;
	private Set<Transaction> transactions = new HashSet<Transaction>(); 

	public Customber() {

	}
	public Customber(int customberId, String firstName, String lastName, String address, long phoneNumber) {
		this.customberId = customberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public Customber(String firstName, String lastName, String address, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
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
		Customber other = (Customber) obj;
		if (customberId != other.customberId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customberId=" + customberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", transactions="
				+ transactions + "]";
	}

}
