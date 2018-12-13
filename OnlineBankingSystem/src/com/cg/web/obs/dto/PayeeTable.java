package com.cg.web.obs.dto;

public class PayeeTable 
{
	private int payeeId;
	private long accountNumber;
	private long payeeAccountNumber;
	private String nickName;
	
	public PayeeTable(){}
	
	public PayeeTable(long accountNumber, long payeeAccountNumber,
			String nickName) {
		super();
		this.accountNumber = accountNumber;
		this.payeeAccountNumber = payeeAccountNumber;
		this.nickName = nickName;
	}



	public int getPayeeId() {
		return payeeId;
	}



	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
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



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	@Override
	public String toString() {
		return "PayeeTable [payeeId=" + payeeId + ", accountNumber="
				+ accountNumber + ", payeeAccountNumber=" + payeeAccountNumber
				+ ", nickName=" + nickName + "]";
	}
	
}
