package com.cg.web.obs.dto;

public class UserTable 
{
	private long accountNumber;
	private String userId;
	private String loginPassword;
	private String secretQuestion;
	private String transactionPassword;
	private String lockStatus;
	
	public UserTable(){}
	
	public UserTable(long accountNumber, String userId, String loginPassword,
			String secretQuestion, String transactionPassword, String lockStatus) {
		super();
		this.accountNumber = accountNumber;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.transactionPassword = transactionPassword;
		this.lockStatus = lockStatus;
	}



	public long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getLoginPassword() {
		return loginPassword;
	}



	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}



	public String getSecretQuestion() {
		return secretQuestion;
	}



	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}



	public String getTransactionPassword() {
		return transactionPassword;
	}



	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}



	public String getLockStatus() {
		return lockStatus;
	}



	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}



	@Override
	public String toString() {
		return "UserTable [accountNumber=" + accountNumber + ", userId="
				+ userId + ", loginPassword=" + loginPassword
				+ ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword
				+ ", lockStatus=" + lockStatus + "]";
	}
	
	
}
