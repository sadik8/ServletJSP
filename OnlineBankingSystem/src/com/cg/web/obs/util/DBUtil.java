package com.cg.web.obs.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil 
{
	static DataSource dataSource = null;
	
	public static DataSource getDataSource() throws NamingException
	{
		if(dataSource==null)
		{
			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/OracleDS/myOracleDS");
		}
		return dataSource;
	}
}
