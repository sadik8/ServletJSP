package com.cg.web.obs.service;

import java.util.List;

import com.cg.web.obs.dao.IOnlineBankingDao;
import com.cg.web.obs.dao.OnlineBankingDaoImpl;
import com.cg.web.obs.dto.AccountMaster;
import com.cg.web.obs.dto.Customer;
import com.cg.web.obs.dto.FundTransfer;
import com.cg.web.obs.dto.PayeeTable;
import com.cg.web.obs.dto.ServiceTracker;
import com.cg.web.obs.dto.Transactions;
import com.cg.web.obs.dto.UserTable;
import com.cg.web.obs.exception.BankingException;

public class OnlineBankingServiceImpl implements IOnlineBankingService
{
	private IOnlineBankingDao bankingDao = new OnlineBankingDaoImpl(); 
	
	@Override
	public int[] createNewAccount(AccountMaster accountMaster, Customer customer, UserTable usertable) throws BankingException
	{
		return bankingDao.createNewAccount(accountMaster, customer, usertable);
	}

	@Override
	public Customer accountHolderLogin(int userId, String password) throws BankingException 
	{
		return bankingDao.accountHolderLogin(userId, password);
	}

	@Override
	public boolean adminLogin(int adminId, String password) throws BankingException
	{
		return bankingDao.adminLogin(adminId, password);
	}
	
	@Override

	public AccountMaster getAccoutOverview(long accountNumber) throws BankingException
	{
		return bankingDao.getAccoutOverview(accountNumber);
	}

	@Override
	public List<Transactions> viewTransactions() throws BankingException 
	{
		return bankingDao.viewTransactions();
	}

	@Override
	public int putServiceRequest(ServiceTracker serviceTracker)
			throws BankingException
	{
		return bankingDao.putServiceRequest(serviceTracker);
	}

	@Override
	public ServiceTracker trackServiceRequest(int serviceId)
			throws BankingException 
	{
		return bankingDao.trackServiceRequest(serviceId);
	}
	
	@Override
	public int changePassword(String oldpassword,String newpassword)
			throws BankingException {
		
		return bankingDao.changePassword(oldpassword,newpassword);
	}

	@Override
	public boolean changeForgotPassword(String password, long accountNumber)
			throws BankingException 
	{
		return bankingDao.changeForgotPassword(password, accountNumber);
	}

	@Override
	public boolean checkoldpassword(String oldpassword) throws BankingException {
		return bankingDao.checkoldpassword(oldpassword);
	}

	@Override
	public boolean checkmaidenname(String maiden, long accountNumber, int userId) throws BankingException 
	{	
		return bankingDao.checkmaidenname(maiden,accountNumber,userId);
	}

	@Override
	public List<PayeeTable> getPayees(long accountNumber)
			throws BankingException 
	{
		return bankingDao.getPayees(accountNumber);
	}

	@Override
	public boolean accountExist(long accountNumber) throws BankingException 
	{
		return bankingDao.accountExist(accountNumber);
	}

	@Override
	public int addPayee(PayeeTable payee) throws BankingException 
	{
		return bankingDao.addPayee(payee);
	}

	@Override
	public int transferFunds(FundTransfer fundTransfer,String transactionPassword)
			throws BankingException 
	{
		int newBalance = 0;
		int newBalancePayee = 0;
		long accountNumber = fundTransfer.getAccountNumber();
		long payeeAccNo = fundTransfer.getPayeeAccountNumber();
		int amount = fundTransfer.getTransferAmount();
		
		String password = bankingDao.getTransactionPassword(accountNumber);
		if(password.equals(transactionPassword))
		{
			int accountBalance = bankingDao.getAccountBalance(accountNumber);
			int accountBalancePayee = bankingDao.getAccountBalance(payeeAccNo);
			if(accountBalance>=amount)
			{
				newBalance = accountBalance - amount;
				newBalancePayee = accountBalancePayee + amount;
				bankingDao.transferFunds(fundTransfer, amount, newBalance, newBalancePayee);
			}
			else
			{
				newBalance=-1;
			}
		}
		else
		{
			newBalance = -2;
		}
		return newBalance;
	}

	@Override
	public List<AccountMaster> getSelfAccounts(String panNo, long accountNo)
			throws BankingException 
	{
		return bankingDao.getSelfAccounts(panNo, accountNo);
	}
	
	@Override
	public Customer getCred(String address, String email,String accountNumber)
			throws BankingException {
		
		return bankingDao.getCred(address, email,accountNumber);
	}

	@Override
	public void changeCred(String address, String email, long accountNumber)
			throws BankingException {
		bankingDao.changeCred(address, email, accountNumber);
		
	}

	@Override
	public List<Transactions> getMiniStatement(long accountNumber)
			throws BankingException 
	{
		return bankingDao.getMiniStatement(accountNumber);
	}
}
