package com.cg.web.obs.service;

import java.util.List;

import com.cg.web.obs.dto.AccountMaster;
import com.cg.web.obs.dto.Customer;
import com.cg.web.obs.dto.FundTransfer;
import com.cg.web.obs.dto.PayeeTable;
import com.cg.web.obs.dto.ServiceTracker;
import com.cg.web.obs.dto.Transactions;
import com.cg.web.obs.dto.UserTable;
import com.cg.web.obs.exception.BankingException;

public interface IOnlineBankingService 
{
	public int[] createNewAccount(AccountMaster accountMaster, Customer customer, UserTable usertable)throws BankingException;
	public List<Transactions> viewTransactions() throws BankingException;
	public Customer accountHolderLogin(int userId,String password) throws BankingException;
	public boolean adminLogin(int adminId,String password) throws BankingException;
	public AccountMaster getAccoutOverview(long accountNumber) throws BankingException;
	public int putServiceRequest(ServiceTracker serviceTracker) throws BankingException;
	public ServiceTracker trackServiceRequest(int serviceId) throws BankingException;
	public int changePassword(String oldpassword,String newpassword) throws BankingException;
	public boolean changeForgotPassword(String password, long accountNumber) throws BankingException;
	public boolean checkoldpassword(String oldpassword)throws BankingException;
	public boolean checkmaidenname(String maidan, long accountNumber, int userId)throws BankingException;
	public List<PayeeTable> getPayees(long accountNumber) throws BankingException;
	public boolean accountExist(long accountNumber) throws BankingException;
	public int addPayee(PayeeTable payee) throws BankingException;
//	public String getTransactionPassword(long accountNumber) throws BankingException;
	public List<AccountMaster> getSelfAccounts(String panNo, long accountNo) throws BankingException;
	public int transferFunds(FundTransfer fundTransfer,String transactionPassword) throws BankingException;
	public Customer getCred(String address,String email,String accountNumber) throws BankingException;
	public void changeCred(String address,String email,long accountNumber)throws BankingException;
	public List<Transactions> getMiniStatement(long accountNumber) throws BankingException;
}
