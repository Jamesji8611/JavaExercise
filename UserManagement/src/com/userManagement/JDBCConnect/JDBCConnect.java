package com.userManagement.JDBCConnect;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCConnect {
	
	public Connection Con = null;
	
	public JDBCConnect() throws NamingException, SQLException{
		
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/SqlServer1");
		
		Con = ds.getConnection();
		
	}
	
	
	
}
