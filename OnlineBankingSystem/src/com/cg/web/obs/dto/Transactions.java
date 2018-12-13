package com.cg.web.obs.dto;

import java.sql.Date;
public class Transactions 
{
	private int transactionID;
	private String transactionDescription;
	private Date dateofTransaction;
	private String transactionType;
	private int transactionAmount;
	private long accountNumber;
	
	public Transactions(){}

	public Transactions(String transactionDescription, String transactionType,
			int transactionAmount, long accountNumber) {
		super();
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.accountNumber = accountNumber;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Date getDateofTransaction() {
		return dateofTransaction;
	}

	public void setDateofTransaction(Date dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Transactions [transactionID=" + transactionID
				+ ", transactionDescription=" + transactionDescription
				+ ", dateofTransaction=" + dateofTransaction
				+ ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount
				+ ", accountNumber=" + accountNumber + "]";
	}
	
	
}
