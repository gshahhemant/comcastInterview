package com.helloworld.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class CustomerInfo implements Serializable {

	private static final long serialVersionUID = -3209024208282628069L;
	private int customberId;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String address;
	
	private long phoneNumber;
			
	
	public CustomerInfo() {
		
	}
	public CustomerInfo(int customberId, String firstName, String lastName, String address, long phoneNumber) {
		super();
		this.customberId = customberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public CustomerInfo(String firstName, String lastName, String address, long phoneNumber) {
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
	@Override
	public String toString() {
		return "CustomberInfo [customberId=" + customberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
