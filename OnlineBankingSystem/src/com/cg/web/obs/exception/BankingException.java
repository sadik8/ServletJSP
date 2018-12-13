package com.cg.web.obs.exception;

public class BankingException extends Exception
{

	public BankingException()
	{
		super();
	}

	public BankingException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) 
	{
		super(arg0, arg1, arg2, arg3);
	}

	public BankingException(String arg0, Throwable arg1) 
	{
		super(arg0, arg1);

	}

	public BankingException(String arg0) 
	{
		super(arg0);
	}

	public BankingException(Throwable arg0) 
	{
		super(arg0);
	}
	
}
