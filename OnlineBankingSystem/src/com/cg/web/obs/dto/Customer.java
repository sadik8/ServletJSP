package com.cg.web.obs.dto;

public class Customer 
{
	private long accountNumber;
	private String customerName;
	private String email;
	private String address;
	private String panNo;
	
	public Customer(){}

	public Customer(long accountNumber, String customerName, String email,
			String address, String panNo) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.panNo = panNo;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", customerName="
				+ customerName + ", email=" + email + ", address=" + address
				+ ", panNo=" + panNo + "]";
	}
	
	
}
