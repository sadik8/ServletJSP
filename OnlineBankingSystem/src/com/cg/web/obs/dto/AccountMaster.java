package com.cg.web.obs.dto;

import java.sql.Date;

public class AccountMaster
{
	private long accountNumber;
	private String accountType;
	private int accountBalance;
	private String ifscCode;
	private Date openDate;
	
	public AccountMaster(){}

	public AccountMaster(String accountType,int accountBalance, String ifscCode)
	{
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.ifscCode = ifscCode;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public java.sql.Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(java.sql.Date openDate) {
		this.openDate = openDate;
	}

	@Override
	public String toString() {
		return "AccountMaster [accountNumber=" + accountNumber
				+ ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", ifscCode=" + ifscCode + ", openDate="
				+ openDate + "]";
	}
}
