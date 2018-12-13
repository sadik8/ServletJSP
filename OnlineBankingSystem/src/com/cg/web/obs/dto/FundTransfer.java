package com.cg.web.obs.dto;

import java.sql.Date;

public class FundTransfer 
{
	private int fundTransferID;
	private long accountNumber;
	private long payeeAccountNumber;
	private Date dateOfTransfer;
	private int transferAmount;
	
	public FundTransfer(){}
	
	public FundTransfer(long accountNumber, long payeeAccountNumber,
			int transferAmount) {
		super();
		this.accountNumber = accountNumber;
		this.payeeAccountNumber = payeeAccountNumber;
		this.transferAmount = transferAmount;
	}



	public int getFundTransferID() {
		return fundTransferID;
	}



	public void setFundTransferID(int fundTransferID) {
		this.fundTransferID = fundTransferID;
	}



	public long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public long getPayeeAccountNumber() {
		return payeeAccountNumber;
	}



	public void setPayeeAccountNumber(long payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}



	public Date getDateOfTransfer() {
		return dateOfTransfer;
	}



	public void setDateOfTransfer(Date dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}



	public int getTransferAmount() {
		return transferAmount;
	}



	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}



	@Override
	public String toString() {
		return "FundTransfer [fundTransferID=" + fundTransferID
				+ ", accountNumber=" + accountNumber + ", payeeAccountNumber="
				+ payeeAccountNumber + ", dateOfTransfer=" + dateOfTransfer
				+ ", transferAmount=" + transferAmount + "]";
	}
	
	
}
