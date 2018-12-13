package com.cg.web.obs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.web.obs.dto.AccountMaster;
import com.cg.web.obs.dto.Customer;
import com.cg.web.obs.dto.FundTransfer;
import com.cg.web.obs.dto.PayeeTable;
import com.cg.web.obs.dto.ServiceTracker;
import com.cg.web.obs.dto.Transactions;
import com.cg.web.obs.dto.UserTable;
import com.cg.web.obs.exception.BankingException;
import com.cg.web.obs.service.IOnlineBankingService;
import com.cg.web.obs.service.OnlineBankingServiceImpl;

@WebServlet("*.do")
public class SystemController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	private IOnlineBankingService bankingService = new OnlineBankingServiceImpl();
	
    public SystemController() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		
		if(action!=null)
		{
			switch(action)
			{
				case "login.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String username = request.getParameter("userName");
					String password = request.getParameter("password");

					String userIdString = username.substring(3,username.length());
					int userId = Integer.parseInt(userIdString);

					if(username.substring(0,3).equals("ACH"))
		 			{	
						RequestDispatcher rd = null;
						Customer customer = null;
						try 
						{
							customer = bankingService.accountHolderLogin(userId, password);
						} 
						catch (BankingException e) 
						{
							e.printStackTrace();
							request.setAttribute("errorMessage", e.getMessage());
							rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
							rd.forward(request, response);
							return;
						}
						
						if(customer != null)
						{
							session.setAttribute("customer", customer);
							rd = request.getRequestDispatcher("/View/AccountHolder/AccountHolderHomePage.jsp");
						}
						else
						{
							request.setAttribute("message", "Username or Password not matched");
							rd = request.getRequestDispatcher("/View/LoginPage.jsp");
						}
						rd.forward(request, response);
						
		 			}
		 			else if(username.substring(0,3).equals("ADM"))
		 			{
						RequestDispatcher rd = null;
						try
						{
							if(bankingService.adminLogin(userId, password))
							{
								session.setAttribute("name", "Admin");
								rd = request.getRequestDispatcher("/View/Admin/AdminHomePage.jsp");
							}
							else
							{
								request.setAttribute("message", "Username or Password not matched");
								rd = request.getRequestDispatcher("/View/LoginPage.jsp");
							}
						} 
						catch (BankingException e) 
						{
							e.printStackTrace();
							request.setAttribute("errorMessage", e.getMessage());
							rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
						}
						rd.forward(request, response);
		 			}
		 			else
		 				System.out.println("Some error Occured");
					
					break;
				}
				
				case "logout.do":
				{						
					HttpSession session = request.getSession(false);
					if(session!=null)
					{
						session.invalidate();
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}
					break;
				}
				
				case "changePassword.do":
				{
					HttpSession session = request.getSession(false);
					RequestDispatcher rd = null;
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					
					String oldpassword = request.getParameter("oldpassword");
					String newpassword = request.getParameter("newpassword");
					try 
					{
						bankingService.changePassword(oldpassword,newpassword);
						request.setAttribute("changeMsg", "Password changed successfully");
						rd = request.getRequestDispatcher("/View/AccountHolder/ChangePassword.jsp");
					} 
					catch (BankingException e)
					{	
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					
					 rd.forward(request, response);
					break;
				}

				case "changed.do":
				{
					HttpSession session = request.getSession(false);
					RequestDispatcher rd = null;
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					Object obj = session.getAttribute("customer");
					Customer customer = null;
					if(obj!=null && obj instanceof Customer)
						customer = (Customer) obj;
					long accountNumber = customer.getAccountNumber();
					String address = request.getParameter("address");
					String email = request.getParameter("email");
					
					
					
					try 
					{
						if(!(customer.getEmail().equals(email) && customer.getAddress().equals(address)))
						{
							bankingService.changeCred(address, email, accountNumber);
							customer.setEmail(email);
							customer.setAddress(address);
							session.setAttribute("customer", customer);
							request.setAttribute("changeMsg", "Credentials Changed Successfully");
							rd = request.getRequestDispatcher("/View/AccountHolder/RequestForChangingCredentials.jsp");
						}
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}

					rd.forward(request, response);
					break;
				}
				
				case "changecred.do":
				{
					HttpSession session = request.getSession(false);
					RequestDispatcher rd;
					if(session==null)
					{
						
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						rd =request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request,response);
						return;
					}
					
					//String acc=request.getParameter("account");
					//int accountNumber  = Integer.parseInt(acc);
					
					Customer customer = (Customer) session.getAttribute("customer");
					
					
						request.setAttribute("cust", customer);
						
						rd= request.getRequestDispatcher("/View/AccountHolder/RequestForChangingCredentials.jsp");						
					
					
					rd.forward(request,response);

					break;
				}
				
				case "forgotPassword.do":
				{
					RequestDispatcher rd = null;
					String accNoStr = request.getParameter("accNo");
					String username = request.getParameter("userId");
					String maidenName = request.getParameter("maiden");
					
					try 
					{
						String userIdString = username.substring(3,username.length());
						
						int userId = Integer.parseInt(userIdString);
						long accountNumber = Long.parseLong(accNoStr);
						boolean isValid = bankingService.checkmaidenname(maidenName,accountNumber,userId);
						if(isValid)
						{
							HttpSession session1 = request.getSession(false);

							if(session1 == null)
							{	
								request.setAttribute("errorMessage", "You are not authorized to access this page");
								rd =request.getRequestDispatcher("ErrorPage.jsp");
								rd.forward(request,response);
								return;
							}
							session1.setAttribute("userId", userIdString);
							session1.setAttribute("accountNumber",accountNumber);
							rd = request.getRequestDispatcher("/View/ChangeOldPassword.jsp");
						}
						else
						{
							request.setAttribute("errorMsg", "Credentials entered are Wrong, Please Try Again!!!");
							rd = request.getRequestDispatcher("/View/ForgotPassword.jsp");
						}
					} 
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				case "passwordchanged.do":
				{
					HttpSession session1 = request.getSession(false);
					if(session1 == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					RequestDispatcher rd = null;
					
					try 
					{
						String password = request.getParameter("password");
						String accNoStr = request.getParameter("accNo");
						long accountNumber = Long.parseLong(accNoStr);
						boolean changed =bankingService.changeForgotPassword(password, accountNumber);
						
						if(changed)
						{
							session1.invalidate();
							request.setAttribute("changeMsg", "Password Changed Successfully, You may login Now");
							rd = request.getRequestDispatcher("/View/LoginPage.jsp");
						}
						else
						{
							request.setAttribute("changeMsg", "Some error Occured, Please try again");
							rd =request.getRequestDispatcher("/View/AccountHolder/ChangeOldPassword.jsp");
						}
					} 
					catch (NumberFormatException e)
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					} 
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				case "createNewAccount.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					AccountMaster accountMaster = new AccountMaster();
					Customer customer = new Customer();
					UserTable userTable = new UserTable();
					int[] accountNo_userId = {0,0};
					
					accountMaster.setAccountType(request.getParameter("accountType"));
					accountMaster.setAccountBalance(Integer.parseInt(request.getParameter("accountBalance")));
					accountMaster.setIfscCode(request.getParameter("ifscCode"));
					
					customer.setCustomerName(request.getParameter("customerName"));
					customer.setEmail(request.getParameter("email"));
					customer.setAddress(request.getParameter("address"));
					customer.setPanNo(request.getParameter("panNo"));
					
					userTable.setLoginPassword(request.getParameter("loginPassword"));
					userTable.setSecretQuestion(request.getParameter("secretQuestion"));
					userTable.setTransactionPassword(request.getParameter("transactionPassword"));
					userTable.setLockStatus(request.getParameter("lockStatus"));
					
					RequestDispatcher rd = null;
					try
					{
						accountNo_userId = bankingService.createNewAccount(accountMaster, customer, userTable);
						request.setAttribute("accountNo_userId", accountNo_userId);
						rd = request.getRequestDispatcher("CreateNewAccount.jsp");
					} 
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}

				case "viewTransactions.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					//System.out.println("------>>>>>>>Inside view Transaction");
					RequestDispatcher rd = null;
					
					try 
					{
						List<Transactions> transactions = bankingService.viewTransactions();
						if(transactions.size() !=0)
							request.setAttribute("transactions", transactions);
						rd = request.getRequestDispatcher("/View/Admin/ViewTransactions.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request,response);					
					break;
				}
				
				case "getAccountOverview.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					RequestDispatcher rd = null;
					
					Object obj = session.getAttribute("customer");
					Customer customer = null;
					if(obj!=null && obj instanceof Customer)
						customer = (Customer) obj;
					
					try
					{
						AccountMaster accountMaster = bankingService.getAccoutOverview(customer.getAccountNumber());
						request.setAttribute("account", accountMaster);
						request.setAttribute("address", customer.getAddress());
						request.setAttribute("email", customer.getEmail());
						rd = request.getRequestDispatcher("/View/AccountHolder/AccountOverview.jsp");
					} 
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					
					rd.forward(request, response);
					break;
				}
				
				case "miniStatement.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					Object obj = session.getAttribute("customer");
					Customer customer = null;
					if(obj!=null && obj instanceof Customer)
						customer = (Customer) obj;
					
					long accountNumber = customer.getAccountNumber();
					RequestDispatcher rd = null;
					try 
					{
						List<Transactions> transactions = bankingService.getMiniStatement(accountNumber);
						if(transactions.size() !=0)
							request.setAttribute("transactions", transactions);
						else
							request.setAttribute("errorMsg","No Transactions Made");
						rd = request.getRequestDispatcher("/View/AccountHolder/MiniStatement.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request,response);		
					break;
				}
				
				case "putServiceRequest.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					Object obj = session.getAttribute("customer");
					Customer customer = null;
					if(obj!=null && obj instanceof Customer)
						customer = (Customer) obj;
					
					ServiceTracker serviceTracker = new ServiceTracker();
					serviceTracker.setServiceDescription(request.getParameter("serviceDescription"));
					serviceTracker.setAccountNumber(customer.getAccountNumber());
					serviceTracker.setServiceStatus("Open");
					
					RequestDispatcher rd = null;
					try
					{
						int serviceId = bankingService.putServiceRequest(serviceTracker);
						request.setAttribute("serviceId", serviceId);
						rd = request.getRequestDispatcher("PutServiceRequest.jsp");
					}
					catch (BankingException e)
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}

				case "trackServiceRequest.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String serviceIdStr = request.getParameter("serviceId");
					ServiceTracker serviceTracker = null;	
					int serviceId = 0;
					
					RequestDispatcher rd = null;
					
					try 
					{
						serviceId = Integer.parseInt(serviceIdStr);
						serviceTracker = bankingService.trackServiceRequest(serviceId);
						
						if(serviceTracker != null)
						{
							request.setAttribute("serviceDetails", serviceTracker);
							rd = request.getRequestDispatcher("TrackServiceRequest.jsp");
						}
						else
						{
							request.setAttribute("norequest", "No Service Record Found with this id : "+serviceId);
							rd = request.getRequestDispatcher("TrackServiceRequest.jsp");
						}
						
					} 
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					} 
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", "No Service request found with this id , Exception = "+e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					
					rd.forward(request, response);
					break;
				}	
				
				case "getSelfAccounts.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					RequestDispatcher rd = null;
					
					try 
					{
						Customer customer = (Customer)session.getAttribute("customer");
						String panNo = customer.getPanNo();
						long accountNo = customer.getAccountNumber();
						List<AccountMaster> selfAccounts = bankingService.getSelfAccounts(panNo, accountNo);
						if(selfAccounts.size() != 0)
							request.setAttribute("selfAccounts", selfAccounts);
						rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/SelfAccount.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				case "transferMoneySelf.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String accNo = request.getParameter("payeeAccountNumber");
					
					RequestDispatcher rd = null;
					request.setAttribute("payeeAccountNo", accNo);
					rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
					rd.forward(request, response);
					break;
				}

				case "makeSelfTransfer.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String accNoStr = request.getParameter("accNo");
					String moneyStr = request.getParameter("money");
					String pass = request.getParameter("transferPassword");
					
					RequestDispatcher rd = null;
					try 
					{
						FundTransfer fundTransfer = new FundTransfer();
						Object customerObj = session.getAttribute("customer");
						Customer customer = (Customer) customerObj;
						
						fundTransfer.setAccountNumber(customer.getAccountNumber());
						Long payeeAccNo = Long.parseLong(accNoStr);
						fundTransfer.setPayeeAccountNumber(payeeAccNo);
						int amount = Integer.parseInt(moneyStr);
						fundTransfer.setTransferAmount(amount);
						
						int newBalance = bankingService.transferFunds(fundTransfer,pass);
						if(newBalance==-1)
						{
							request.setAttribute("payeeAccNo", payeeAccNo);
							request.setAttribute("noBalance", "No Sufficient Balance for this transaction");
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
						}
						else if(newBalance == -2)
						{
							request.setAttribute("payeeAccNo", payeeAccNo);
							request.setAttribute("noBalance", "Your transaction password is incorrect, Please try again");
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
						}
						else
						{
							request.setAttribute("newBalance", "Fund Successfully Transferred, Remaining Balance : "+newBalance);
							rd = request.getRequestDispatcher("/View/AccountHolder/TransferFunds.jsp");
						}
					}
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				case "getPayees.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					RequestDispatcher rd = null;
					
					try 
					{
						Customer customer = (Customer)session.getAttribute("customer");
						long accountNumber = customer.getAccountNumber();
						List<PayeeTable> payees = bankingService.getPayees(accountNumber);
											
						if(payees.size() !=0)
							request.setAttribute("payees", payees);
						rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/OtherAccounts.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request,response);					
					break;
				}
				
				case "addPayee.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					RequestDispatcher rd = null;
					
					try {
						Customer customer = (Customer)session.getAttribute("customer");
						long accountNumber = customer.getAccountNumber();
						
						String payeeAccNoStr = request.getParameter("accountNo");
						String nickName = request.getParameter("nickName");
						long payeeAccNo = Long.parseLong(payeeAccNoStr);
						
						if(bankingService.accountExist(payeeAccNo))
						{
							PayeeTable payee = new PayeeTable(accountNumber,payeeAccNo,nickName);
							int payeeId = bankingService.addPayee(payee);
							request.setAttribute("payeeId", payeeId);
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/AddPayee.jsp");
						}
						else
						{
							request.setAttribute("errorMessage", "No account exists with this account number");
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/AddPayee.jsp");
						}						
					}
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				case "transferMoney.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String str = request.getParameter("payeeId");
					String []payee = str.split(",");
					String payeeIdStr = payee[0];
					String nickName = payee[1];
					String accNo = payee[2];


					RequestDispatcher rd = null;
					request.setAttribute("id", payeeIdStr);
					request.setAttribute("name", nickName);
					request.setAttribute("payeeAccNo", accNo);
					rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
					rd.forward(request, response);
					break;
				}
				
				case "makeTransfer.do":
				{
					HttpSession session = request.getSession(false);
					if(session == null)
					{
						request.setAttribute("errorMessage", "You are not authorized to access this page");
						RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
						rd.forward(request, response);
						return;
					}
					
					String id = request.getParameter("payeeId");
					String nickName = request.getParameter("nickName");
					String accNoStr = request.getParameter("accNo");
					String moneyStr = request.getParameter("money");
					String pass = request.getParameter("transferPassword");
					
					RequestDispatcher rd = null;
					try 
					{
						FundTransfer fundTransfer = new FundTransfer();
						Object customerObj = session.getAttribute("customer");
						Customer customer = (Customer) customerObj;
						
						fundTransfer.setAccountNumber(customer.getAccountNumber());
						Long payeeAccNo = Long.parseLong(accNoStr);
						fundTransfer.setPayeeAccountNumber(payeeAccNo);
						int amount = Integer.parseInt(moneyStr);
						fundTransfer.setTransferAmount(amount);
						
						int newBalance = bankingService.transferFunds(fundTransfer,pass);
						if(newBalance==-1)
						{
							request.setAttribute("id", id);
							request.setAttribute("name", nickName);
							request.setAttribute("payeeAccNo", payeeAccNo);
							request.setAttribute("noBalance", "No Sufficient Balance for this transaction");
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
						}
						else if(newBalance == -2)
						{
							request.setAttribute("id", id);
							request.setAttribute("name", nickName);
							request.setAttribute("payeeAccNo", payeeAccNo);
							request.setAttribute("noBalance", "Your transaction password is incorrect, Please try again");
							rd = request.getRequestDispatcher("/View/AccountHolder/FundTransfer/TransferPage.jsp");
						}
						else
						{
							request.setAttribute("newBalance", "Fund Successfully Transferred, Remaining Balance : "+newBalance);
							rd = request.getRequestDispatcher("/View/AccountHolder/TransferFunds.jsp");
						}
					}
					catch (NumberFormatException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					catch (BankingException e) 
					{
						e.printStackTrace();
						request.setAttribute("errorMessage", e.getMessage());
						rd = request.getRequestDispatcher("/View/ErrorPage.jsp");
					}
					rd.forward(request, response);
					break;
				}
				
				default : 
				{
					
				}
			}
		}
		else
		{
			System.out.println("---------->>>>>>>>>>>>>>>>>Action is null");
		}

	}

}
