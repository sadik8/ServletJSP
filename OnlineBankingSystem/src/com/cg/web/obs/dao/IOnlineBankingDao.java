package com.cg.web.obs.dao;

import java.util.List;

import com.cg.web.obs.dto.*;
import com.cg.web.obs.exception.BankingException;

public interface IOnlineBankingDao 
{
	public int[] createNewAccount(AccountMaster accountMaster, Customer customer, UserTable usertable) throws BankingException;
	public List<Transactions> viewTransactions() throws BankingException;
	public Customer accountHolderLogin(int userId,String password) throws BankingException;
	public boolean adminLogin(int adminId,String password) throws BankingException;
	public AccountMaster getAccoutOverview(long accountNumber) throws BankingException;
	public int putServiceRequest(ServiceTracker serviceTracker) throws BankingException;
	public ServiceTracker trackServiceRequest(int serviceId) throws BankingException;
	public int changePassword(String oldpassword,String newpassword) throws BankingException;
	public boolean changeForgotPassword(String password, long accountNumber) throws BankingException;
	public boolean checkoldpassword(String oldpassword)throws BankingException;
	public boolean checkmaidenname(String maiden, long accountNumber, int userId)throws BankingException;
	public List<PayeeTable> getPayees(long accountNumber) throws BankingException;
	public boolean accountExist(long accountNumber) throws BankingException;
	public int addPayee(PayeeTable payee) throws BankingException;
	public int getAccountBalance(long accountNumber) throws BankingException;
	public List<AccountMaster> getSelfAccounts(String panNo, long accountNo) throws BankingException;
	public String getTransactionPassword(long accountNumber) throws BankingException;
	public void transferFunds(FundTransfer fundTransfer, int amount, int newBalance, int newBalancePayee) throws BankingException;
	public Customer getCred(String address,String email,String accountNumber) throws BankingException;
	public void changeCred(String address,String email,long accountNumber)throws BankingException;
	public List<Transactions> getMiniStatement(long accountNumber) throws BankingException;
	
}
