package com.cg.web.obs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.web.obs.util.DBUtil;
import com.cg.web.obs.dto.AccountMaster;
import com.cg.web.obs.dto.Customer;
import com.cg.web.obs.dto.FundTransfer;
import com.cg.web.obs.dto.PayeeTable;
import com.cg.web.obs.dto.ServiceTracker;
import com.cg.web.obs.dto.Transactions;
import com.cg.web.obs.dto.UserTable;
import com.cg.web.obs.exception.BankingException;

public class OnlineBankingDaoImpl implements IOnlineBankingDao
{	
	private int getAccountNumber() throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		int accountNumber=0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT accountNumber_seq.NEXTVAL FROM DUAL");
			rs.next();
			accountNumber=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return accountNumber;
	}
	
	private int getUserId() throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		int userId				= 0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT userId_seq.NEXTVAL FROM DUAL");
			rs.next();
			userId=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return userId;
	}
	
	private int getServiceId() throws BankingException
	{

		DataSource dataSource	= null;
		Connection con 			= null;
		int serviceId			= 0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT serviceId_seq.NEXTVAL FROM DUAL");
			rs.next();
			serviceId=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return serviceId;
	}
	
	private int getPayeeId() throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		int payeeId=0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT payeeId_seq.NEXTVAL FROM DUAL");
			rs.next();
			payeeId=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return payeeId;
	}
	
	private int getFundTransferId() throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		int fundTransferId		= 0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT fundTransfer_seq.NEXTVAL FROM DUAL");
			rs.next();
			fundTransferId=rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return fundTransferId;
	}
	
	public int getTransactionId() throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		int transactionId		= 0;
		try
		{
			dataSource	= DBUtil.getDataSource();
			con 		= dataSource.getConnection();
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT transactionId_seq.NEXTVAL FROM DUAL");
			rs.next();
			transactionId = rs.getInt(1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return transactionId;
	}
	
	@Override
	public int[] createNewAccount(AccountMaster accountMaster, Customer customer, UserTable usertable) throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int [] accountNo_userId	= {0,0};
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			//creating account number for new user
			int accountNumber = getAccountNumber();		
			String accountType = accountMaster.getAccountType();
			int accountBalance = accountMaster.getAccountBalance();
			String ifscCode = accountMaster.getIfscCode();
			
			pst = con.prepareStatement("INSERT into AccountMaster values(?,?,?,?,sysdate)");
			pst.setInt(1, accountNumber);
			pst.setString(2, accountType);
			pst.setInt(3, accountBalance);
			pst.setString(4, ifscCode);
			pst.executeUpdate();

			//Getting customer details to put into database
			String customerName = customer.getCustomerName();
			String email = customer.getEmail();
			String address = customer.getAddress();
			String panNo = customer.getPanNo();
			
			pst = con.prepareStatement("INSERT into Customer values(?,?,?,?,?)");
			pst.setInt(1, accountNumber);
			pst.setString(2, customerName);
			pst.setString(3, email);
			pst.setString(4, address);
			pst.setString(5, panNo);
			pst.executeUpdate();
			
			//Getting user info to put into userTable
			int userId = getUserId();
			String loginPassword = usertable.getLoginPassword();
			String secretQuestion = usertable.getSecretQuestion();
			String trasactionPassword = usertable.getTransactionPassword();
			String lockStatus = usertable.getLockStatus();
	
			pst = con.prepareStatement("INSERT INTO UserTable VALUES(?,?,?,?,?,?)");
			pst.setInt(1, accountNumber);
			pst.setInt(2, userId);
			pst.setString(3, loginPassword);
			pst.setString(4, secretQuestion);
			pst.setString(5, trasactionPassword);
			pst.setString(6, lockStatus);
			pst.executeUpdate();
			
			accountNo_userId[0]=accountNumber;
			accountNo_userId[1]=userId;
			
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return accountNo_userId;
	}

	@Override
	public Customer accountHolderLogin(int userId, String password)
			throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		Customer customer		= null;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT userId,loginPassword,accountNumber from UserTable where userId=? and loginPassword=?");
			pst.setInt(1, userId);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1) == userId && rs.getString(2).equals(password))
				{
					pst = con.prepareStatement("SELECT *from customer where accountNumber=?");
					pst.setInt(1, rs.getInt(3));
					ResultSet rs1 = pst.executeQuery();
					
					rs1.next();
					customer = new Customer();
					customer.setAccountNumber(rs1.getInt(1));
					customer.setCustomerName(rs1.getString(2));
					customer.setEmail(rs1.getString(3));
					customer.setAddress(rs1.getString(4));
					customer.setPanNo(rs1.getString(5));
				}
			}
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}				
		finally
		{
			try 
			{
				if(con!=null)
					con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new BankingException(e.getMessage());
			}
		}
		return customer;
	}

	@Override
	public boolean adminLogin(int adminId, String password) throws BankingException
	{
		boolean isValid			= false;
		DataSource dataSource	= null;
		Connection con 			= null;
		
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT *from admin where adminId=? and Password=?");
			pst.setInt(1, adminId);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1) == adminId && rs.getString(2).equals(password))
					isValid=true;
			}
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}		
		finally
		{
			try 
			{
				if(con!=null)
					con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new BankingException(e.getMessage());
			}
		}
		return isValid;
	}

	@Override
	public List<Transactions> viewTransactions() throws BankingException
	{
		List<Transactions> transactions = new ArrayList<Transactions>();
		DataSource dataSource	= null;
		Connection con 			= null;
		Transactions transaction= null;
		
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *from transactions order by transactionId desc");
			while(rs.next())
			{
				transaction = new Transactions();
				transaction.setTransactionID(rs.getInt(1));
				transaction.setTransactionDescription(rs.getString(2));
				transaction.setDateofTransaction(rs.getDate(3));
				transaction.setTransactionType(rs.getString(4));
				transaction.setTransactionAmount(rs.getInt(5));
				transaction.setAccountNumber(rs.getInt(6));
				transactions.add(transaction);
			}
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return transactions;
	}
	
	@Override
	public AccountMaster getAccoutOverview(long accountNumber) throws BankingException
	{
		AccountMaster accountMaster = new AccountMaster();
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT *FROM AccountMaster WHERE accountNumber = ?");
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			accountMaster.setAccountNumber(accountNumber);
			accountMaster.setAccountType(rs.getString(2));
			accountMaster.setAccountBalance(rs.getInt(3));
			accountMaster.setIfscCode(rs.getString(4));
			accountMaster.setOpenDate(rs.getDate(5));
						
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		
		return accountMaster;
	}

	@Override
	public int putServiceRequest(ServiceTracker serviceTracker)
			throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int serviceId			= 0;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			//creating account number for new user
			serviceId = getServiceId();		
			String serviceDescription = serviceTracker.getServiceDescription();
			long accountNumber = serviceTracker.getAccountNumber();
			String serviceStatus = serviceTracker.getServiceStatus();
			
			pst = con.prepareStatement("INSERT into ServiceTracker values(?,?,?,sysdate,?)");
			pst.setInt(1, serviceId);
			pst.setString(2, serviceDescription);
			pst.setLong(3, accountNumber);
			pst.setString(4, serviceStatus);
			pst.executeUpdate();
						
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		
		return serviceId;
	}

	@Override
	public ServiceTracker trackServiceRequest(int serviceId)
			throws BankingException 
	{
		ServiceTracker serviceTracker	= null;
		DataSource dataSource			= null;
		Connection con 					= null;
		PreparedStatement pst			= null;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT *FROM servicetracker WHERE serviceId=?");
			pst.setInt(1, serviceId);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())			
			{
				serviceTracker = new ServiceTracker();
				serviceTracker.setServiceID(serviceId);
				serviceTracker.setServiceDescription(rs.getString(2));
				serviceTracker.setAccountNumber(rs.getInt(3));
				serviceTracker.setServiceRaisedDate(rs.getDate(4));
				serviceTracker.setServiceStatus(rs.getString(5));
			}		
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return serviceTracker;
	}

	@Override
	public int changePassword(String oldpassword,String newpassword) throws BankingException 
	{

		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int serviceId			= 0;
		try 
		{
			boolean var=checkoldpassword(oldpassword);
			if(var==true)
			{
				dataSource = DBUtil.getDataSource();
				con = dataSource.getConnection();
				//String loginPassword = usertable.getLoginPassword();
				pst = con.prepareStatement("UPDATE UserTable set LOGINPASSWORD=? where LOGINPASSWORD=?");

				pst.setString(1,newpassword);
				pst.setString(2, oldpassword);

				pst.executeUpdate();
				pst.close();
			}
			else
			{
				throw new BankingException("Wrong Old Password");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}

		return serviceId;
	}

	@Override
	public boolean changeForgotPassword(String password, long accountNumber)
			throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		boolean changed			= false;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			//String loginPassword = usertable.getLoginPassword();
			pst = con.prepareStatement("UPDATE UserTable set loginPassword = ? where accountNumber = ?");
			pst.setString(1, password);
			pst.setLong(2, accountNumber);
			pst.executeUpdate();
			pst.close();	
			changed = true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return changed;
	}

	@Override
	public boolean checkoldpassword(String oldpassword) throws BankingException 
	{
		boolean isValid			= false;
		DataSource dataSource	= null;
		Connection con 			= null;

		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT LOGINPASSWORD from usertable where LOGINPASSWORD=?");

			pst.setString(1, oldpassword);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString(1).equals(oldpassword))
					isValid=true;
			}
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}		
		finally
		{
			try 
			{
				if(con!=null)
					con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new BankingException();
			}
		}
		return isValid;
	}

	@Override
	public boolean checkmaidenname(String maiden, long accountNumber, int userId)throws BankingException
	{
		boolean isValid			= false;
		DataSource dataSource	= null;
		Connection con 			= null;

		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT secretQuestion FROM UserTable WHERE accountnumber=? and userId=?");
			pst.setLong(1, accountNumber);
			pst.setInt(2, userId);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString(1).equals(maiden))
					isValid=true;
			}
		} 
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}		
		finally
		{
			try 
			{
				if(con!=null)
					con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
				throw new BankingException();
			}
		}
		return isValid;	
	}

	@Override
	public List<PayeeTable> getPayees(long accountNumber) throws BankingException 
	{
		List<PayeeTable> payees = new ArrayList<PayeeTable>();
		DataSource dataSource	= null;
		Connection con 			= null;
		PayeeTable payee		= null;
		
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT *FROM payeetable WHERE accountnumber=?");
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				payee = new PayeeTable();
				payee.setPayeeId(rs.getInt(1));
				payee.setAccountNumber(rs.getInt(2));
				payee.setPayeeAccountNumber(rs.getInt(3));
				payee.setNickName(rs.getString(4));
				payees.add(payee);
			}
			pst.close();
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		
		return payees;
	}

	@Override
	public boolean accountExist(long accountNumber) throws BankingException
	{
		boolean exists = false;
		
		DataSource dataSource	= null;
		Connection con 			= null;
		
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM accountmaster WHERE accountnumber=?");
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if(rs.getInt(1) != 0)
				exists = true;
			pst.close();
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		
		return exists;
	}

	@Override
	public int addPayee(PayeeTable payee) throws BankingException
	{
		System.out.println("inside payee table");
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int payeeId				= 0;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			//creating payee Id for new user
			payeeId = getPayeeId();		
			long accountNumber = payee.getAccountNumber();
			long payeeAccNo = payee.getPayeeAccountNumber();
			String nickName = payee.getNickName();
						
			pst = con.prepareStatement("INSERT into PayeeTable values(?,?,?,?)");
			pst.setInt(1, payeeId);
			pst.setLong(2, accountNumber);
			pst.setLong(3, payeeAccNo);
			pst.setString(4, nickName);
			pst.executeUpdate();
						
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return payeeId;
	}
	
	@Override
	public int getAccountBalance(long accountNumber) throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int accountBalance		= 0;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT accountBalance FROM AccountMaster WHERE accountNumber=?");
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			rs.next();
			accountBalance=rs.getInt(1);
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return accountBalance;
	}
	
	@Override
	public void transferFunds(FundTransfer fundTransfer, int amount, int newBalance, int newBalancePayee)
			throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		int transferId			= 0;
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			long accountNumber = fundTransfer.getAccountNumber();
			long payeeAccNo = fundTransfer.getPayeeAccountNumber();
			
			transferId = getFundTransferId();
			pst = con.prepareStatement("INSERT INTO FundTransfer VALUES(?,?,?,sysdate,?)");
			pst.setInt(1, transferId);
			pst.setLong(2, accountNumber);
			pst.setLong(3, payeeAccNo);
			pst.setInt(4, fundTransfer.getTransferAmount());
			pst.execute();
			
			int transactionId = getTransactionId();
			String description = "Fund transfer to account no - "+payeeAccNo;
			pst = con.prepareStatement("INSERT INTO Transactions VALUES(?,?,sysdate,'D',?,?)");
			pst.setInt(1, transactionId);
			pst.setString(2, description);
			pst.setInt(3, amount);
			pst.setLong(4, accountNumber);
			pst.execute();
			
			pst = con.prepareStatement("UPDATE accountmaster SET accountBalance =? WHERE accountNumber = ?");
			pst.setInt(1, newBalance);
			pst.setLong(2, accountNumber);
			pst.executeUpdate();
			
			transactionId = getTransactionId();
			description = "Fund recieved by account no - "+accountNumber;
			pst = con.prepareStatement("INSERT INTO Transactions VALUES(?,?,sysdate,'C',?,?)");
			pst.setInt(1, transactionId);
			pst.setString(2, description);
			pst.setInt(3, amount);
			pst.setLong(4, payeeAccNo);
			pst.execute();
			
			pst = con.prepareStatement("UPDATE accountmaster SET accountBalance=? WHERE accountNumber = ?");
			pst.setInt(1, newBalancePayee);
			pst.setLong(2, payeeAccNo);
			pst.executeUpdate();
			
			System.out.println("----->>>>>>>Inside fund transfer Dao");
			
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
	}
	
	@Override
	public String getTransactionPassword(long accountNumber)
			throws BankingException
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		String password			= "";
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT transactionPassword FROM UserTable WHERE accountNumber=?");
			pst.setLong(1, accountNumber);
			ResultSet rs = pst.executeQuery();
			rs.next();
			password = rs.getString(1);
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return password;
	}

	@Override
	public List<AccountMaster> getSelfAccounts(String panNo, long accountNo)
			throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		List<AccountMaster> selfAccounts	= new ArrayList<AccountMaster>();
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT accountnumber,accounttype,ifsccode "
					+ "FROM customer NATURAL JOIN accountmaster WHERE panNo = ? AND accountNumber != ?");
			pst.setString(1, panNo);
			pst.setLong(2, accountNo); 
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				AccountMaster account = new AccountMaster();
				account.setAccountNumber(rs.getLong(1));
				account.setAccountType(rs.getString(2));
				account.setIfscCode(rs.getString(3));
				selfAccounts.add(account);
			}
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return selfAccounts;
	}

	@Override
	public Customer getCred(String address, String email,String accountNumber)
			throws BankingException {
		DataSource dataSource	= null;
		Connection con 			= null;
		Customer cust= null;

		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			PreparedStatement pstm = con.prepareStatement("select * from customer");
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				cust = new Customer();
				cust.setAccountNumber(rs.getLong("accountnumber"));
				cust.setAddress(rs.getString("address"));
				cust.setEmail(rs.getString("email"));
				
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return cust;
	}

	

	@Override
	public void changeCred(String address, String email, long accountNumber)
			throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		
		try 		
		{			
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("UPDATE Customer set address=?,email=? where accountnumber=?");

			pst.setString(1,address);
			pst.setString(2, email);
			pst.setLong(3, accountNumber);

			pst.executeUpdate();

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
	}

	@Override
	public List<Transactions> getMiniStatement(long accountNumber) throws BankingException 
	{
		DataSource dataSource	= null;
		Connection con 			= null;
		PreparedStatement pst	= null;
		List<Transactions> transactions = new ArrayList<Transactions>();
		try 
		{
			dataSource = DBUtil.getDataSource();
			con = dataSource.getConnection();
			
			pst = con.prepareStatement("SELECT *FROM Transactions WHERE accountNumber = ? order by transactionID desc");
			pst.setLong(1, accountNumber); 
			ResultSet rs = pst.executeQuery();
			for(int i=0; i<10 && rs.next();i++)
			{
				Transactions transaction = new Transactions();
				transaction.setTransactionID(rs.getInt(1));
				transaction.setTransactionDescription(rs.getString(2));
				transaction.setDateofTransaction(rs.getDate(3));
				transaction.setTransactionType(rs.getString(4));
				transaction.setTransactionAmount(rs.getInt(5));
				transaction.setAccountNumber(rs.getLong(6));
				transactions.add(transaction);
			}
			pst.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
			throw new BankingException(e.getMessage());
		}
		finally
		{	
			if(con!=null)
			{
				try 
				{
					con.close();
				}  
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new BankingException(e.getMessage());
				}
			}
		}
		return transactions;
	}
}